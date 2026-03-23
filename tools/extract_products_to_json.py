from pathlib import Path
import json
import re


def split_top_level_args(text: str) -> list[str]:
    out: list[str] = []
    current: list[str] = []
    depth = 0
    in_string = False
    escaped = False

    for ch in text:
        if in_string:
            current.append(ch)
            if escaped:
                escaped = False
            elif ch == "\\":
                escaped = True
            elif ch == '"':
                in_string = False
            continue

        if ch == '"':
            in_string = True
            current.append(ch)
            continue
        if ch == "(":
            depth += 1
            current.append(ch)
            continue
        if ch == ")":
            depth -= 1
            current.append(ch)
            continue
        if ch == "," and depth == 0:
            out.append("".join(current).strip())
            current = []
            continue

        current.append(ch)

    if current:
        out.append("".join(current).strip())
    return out


def unescape_java_string(value: str) -> str:
    return (
        value.replace("\\n", "\n")
        .replace("\\t", "\t")
        .replace('\\"', '"')
        .replace("\\\\", "\\")
    )


def find_matching_paren(text: str, start: int) -> int:
    depth = 1
    in_string = False
    escaped = False
    i = start
    while i < len(text):
        ch = text[i]
        if in_string:
            if escaped:
                escaped = False
            elif ch == "\\":
                escaped = True
            elif ch == '"':
                in_string = False
            i += 1
            continue

        if ch == '"':
            in_string = True
        elif ch == "(":
            depth += 1
        elif ch == ")":
            depth -= 1
            if depth == 0:
                return i
        i += 1
    raise ValueError("No matching parenthesis found")


def main() -> None:
    root = Path(__file__).resolve().parents[1]
    source_file = root / "app/src/main/java/com/example/recipeapp/data/static_data/Products.java"
    out_file = root / "app/src/main/assets/products.json"

    source = source_file.read_text(encoding="utf-8")
    marker = "productList = new ArrayList<>(Arrays.asList("
    start = source.index(marker) + len(marker)
    end = source.index("));", start)
    body = source[start:end]

    products = []
    i = 0
    while True:
        marker_idx = body.find("new Product(", i)
        if marker_idx < 0:
            break
        args_start = marker_idx + len("new Product(")
        args_end = find_matching_paren(body, args_start)
        i = args_end + 1

        args_text = body[args_start:args_end]
        args = split_top_level_args(args_text)
        if len(args) < 7:
            continue

        product_id = int(args[0])
        name = unescape_java_string(args[1][1:-1])
        image = args[2].split("R.drawable.", 1)[1]
        time_complete = int(args[3])

        ingredients = []
        for match in re.finditer(r'ingredient\((\d+),\s*"((?:\\.|[^"\\])*)"\)', args[4], flags=re.S):
            ingredients.append(
                {
                    "index": int(match.group(1)),
                    "quantity": unescape_java_string(match.group(2)),
                }
            )

        procedures = []
        for match in re.finditer(
            r'new Procedure\("((?:\\.|[^"\\])*)",\s*"((?:\\.|[^"\\])*)"\)',
            args[5],
            flags=re.S,
        ):
            procedures.append(
                {
                    "step": unescape_java_string(match.group(1)),
                    "des": unescape_java_string(match.group(2)),
                }
            )

        category_ids = [int(x) for x in re.findall(r"category\((\d+)\)", args[6])]

        products.append(
            {
                "id": product_id,
                "name": name,
                "image": image,
                "timeComplete": time_complete,
                "ingredients": ingredients,
                "procedures": procedures,
                "categoryIds": category_ids,
            }
        )

    out_file.parent.mkdir(parents=True, exist_ok=True)
    out_file.write_text(json.dumps({"products": products}, ensure_ascii=False, indent=2), encoding="utf-8")
    print(f"Wrote {len(products)} products to {out_file}")


if __name__ == "__main__":
    main()
