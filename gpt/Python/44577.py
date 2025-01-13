import os\nimport re\n\ndef clean_html_file(file_path):\n    with open(file_path, 'r', encoding='utf-8') as file:\n        content = file.read()\n\n    # Regex pattern to find hidden iframes and suspicious scripts\n    patterns = [\n        re.compile(r'<iframe[^>]*hidden[^>]*>.*?</iframe>', re.IGNORECASE | re.DOTALL),\n        re.compile(r'<script[^>]*>(.*?)</script>', re.IGNORECASE | re.DOTALL)\n    ]\n\n    for pattern in patterns:\n        content = pattern.sub('', content)\n\n    with open(file_path, 'w', encoding='utf-8') as file:\n        file.write(content)\n\ndef clean_website_directory(directory):\n    for root, _, files in os.walk(directory):\n        for file in files:\n            if file.endswith('.html') or file.endswith('.js'):\n                clean_html_file(os.path.join(root, file))\n\n# Provide the path to your website directory\nwebsite_directory = '/path/to/your/website'\nclean_website_directory(website_directory)