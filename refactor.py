import os
base_dir = "src/main/java/stock1337/stock1337"
for root, dirs, files in os.walk(base_dir):
    for str_file in files:
        if str_file.endswith(".java"):
            filepath = os.path.join(root, str_file)
            try:
                with open(filepath, "r") as f:
                    content = f.read()
            except:
                continue
            new_content = []
            for line in content.split("\n"):
                if line.startswith("package "):
                    pkg = line.strip().split(" ")[1][:-1]
                    if not pkg.startswith("stock1337.stock1337") and pkg != "stock1337.stock1337":
                        line = f"package stock1337.stock1337.{pkg};"
                elif line.startswith("import "):
                    imp = line.strip().split(" ")[1][:-1]
                    parts = imp.split(".")
                    if parts[0] in ("Model", "Repository", "Service", "Configuration", "DTO", "Enums", "ServiceAuth"):
                        line = f"import stock1337.stock1337.{imp};"
                new_content.append(line)
            with open(filepath, "w") as f:
                f.write("\n".join(new_content))
print("Refactoring complete.")
