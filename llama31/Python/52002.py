from bs4 import BeautifulSoup\n\ndef html_to_plain_text(html):\n    soup = BeautifulSoup(html, 'html.parser')\n    return soup.get_text()