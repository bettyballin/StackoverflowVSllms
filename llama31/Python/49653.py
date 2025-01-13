from bs4 import BeautifulSoup\nimport htmlmin\n\n# Load HTML file\nwith open('input.html', 'r') as f:\n    html = f.read()\n\n# Parse HTML using BeautifulSoup\nsoup = BeautifulSoup(html, 'html.parser')\n\n# Remove redundant styles and classes\n# ...\n\n# Minify HTML using htmlmin\nminified_html = htmlmin.minify(str(soup), remove_empty_space=True)\n\n# Save optimized HTML to file\nwith open('output.html', 'w') as f:\n    f.write(minified_html)