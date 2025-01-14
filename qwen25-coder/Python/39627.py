from bs4 import BeautifulSoup\n\n# Sample poorly formatted HTML\nhtml_content = """\n<html>\n...\n  <tr><td>Table column that is missing a td \n      <td> Another table column</td></tr>\n  <tr><td>Data Item 1</td>\n...\n</html>\n"""\n\n# Parse the HTML content using BeautifulSoup\nsoup = BeautifulSoup(html_content, 'html.parser')\n\n# Find all table rows and extract data items\ntable_rows = soup.find_all('tr')\nfor row in table_rows:\n    cells = row.find_all(['td', 'li'])  # Handle both <td> and <li> tags\n    for cell in cells:\n        if "Data Item" in cell.text:\n            print("Extracted Data:", cell.text.strip())