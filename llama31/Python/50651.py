from bs4 import BeautifulSoup\n\nsoup = BeautifulSoup(html_string, 'html.parser')\ndata_item_1 = soup.select_one('tr > td:nth-child(2)').text.strip()