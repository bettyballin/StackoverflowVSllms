import os\nfrom pygments import highlight\nfrom pygments.lexers import get_lexer_by_name\nfrom pygments.formatters import HtmlFormatter\n\n# Directory containing your code snippets\ncode_dir = 'path/to/your/cvs/checkout'\noutput_dir = 'path/to/output/html'\nindex_file = os.path.join(output_dir, 'index.html')\n\n# Supported file extensions and their corresponding Pygments lexers\nsupported_extensions = {\n    'py': 'python',\n    'c': 'c',\n    'cpp': 'cpp',\n    # Add more as needed\n}\n\n# Create output directory if it doesn't exist\nos.makedirs(output_dir, exist_ok=True)\n\n# Index content\nindex_content = []\n\n# Process each file in the code directory\nfor root, _, files in os.walk(code_dir):\n    for file in files:\n        ext = file.split('.')[-1]\n        if ext in supported_extensions:\n            lexer = get_lexer_by_name(supported_extensions[ext])\n            formatter = HtmlFormatter(full=True, linenos=True)\n            \n            file_path = os.path.join(root, file)\n            with open(file_path, 'r') as f:\n                code = f.read()\n            \n            highlighted_code = highlight(code, lexer, formatter)\n            \n            output_file = os.path.join(output_dir, f"{file}.html")\n            with open(output_file, 'w') as f:\n                f.write(highlighted_code)\n            \n            index_content.append(f'<li><a href="{file}.html">{file}</a></li>')\n\n# Write index file\nwith open(index_file, 'w') as f:\n    f.write('<html><body><h1>Code Snippets</h1><ul>')\n    f.write('\n'.join(index_content))\n    f.write('</ul></body></html>')\n\nprint("Website generation complete.")