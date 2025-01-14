from bs4 import BeautifulSoup\n\nhtml_code = """\n<!-- Your HTML code here -->\n"""\n\ntry:\n    soup = BeautifulSoup(html_code, 'html.parser')\n    # Now you can navigate the DOM tree using BeautifulSoup methods\n    print(soup.prettify())\nexcept Exception as e:\n    print(f"An error occurred: {e}")