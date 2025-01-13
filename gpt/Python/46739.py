import re\n\nhtml_content = """\n<!DOCTYPE html>\n<html>\n<head>\n    <title>Test Document</title>\n</head>\n<body>\n    <h1>Hello, World!</h1>\n    <p>This is a test document.</p>\n</body>\n</html>\n"""\n\npattern = re.compile(r'(?i)(<body[^>]*>)(.*?)</body>', re.DOTALL)\nmatch = pattern.search(html_content)\n\nif match:\n    body_content = match.group(2)\nelse:\n    body_content = html_content  # If no body tags present, return entire content\n\nprint(body_content.strip())