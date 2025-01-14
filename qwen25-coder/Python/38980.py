from bs4 import BeautifulSoup\n\n# Another sample HTML snippet\nhtml_snippet = """\n<font size="+0"><font face="serif" size="1"><i>Apples Produced</i><font size="3">       \n  </font></font></font>\n"""\n\n# Parse the HTML\nsoup = BeautifulSoup(html_snippet, 'html.parser')\n\n# Extract text from the parsed HTML\ntext_content = soup.get_text(strip=True)\n\nprint(text_content)  # Output: Apples Produced