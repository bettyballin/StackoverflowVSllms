from mechanize import Browser\nfrom bs4 import BeautifulSoup\n\nbr = Browser()\nbr.open('http://somewebpage')\nhtml = br.response().readlines()\n\nfor line in html:\n    # Parse each line with BeautifulSoup\n    soup = BeautifulSoup(line, 'html.parser')\n    # Get the text content from the parsed HTML\n    print(soup.get_text())