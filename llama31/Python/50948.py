import re\n\nurl = "http://www.domain.com/folder1/folder2/file_path.txt"\n\nmatch = re.match(r"^https?:\/\/[^\/]+(.*)$", url)\n\nif match:\n    path = match.group(1)\n    print(path)