from bs4 import BeautifulSoup\n\n# Using BeautifulSoup to parse the HTML\nsoup = BeautifulSoup(html_content, 'html.parser')\nimg_tags = soup.find_all('img')\n\n# Extracting src attributes from each img tag\nimg_srcs_list = [img['src'] for img in img_tags if 'src' in img.attrs]\n\nprint(img_srcs_list)