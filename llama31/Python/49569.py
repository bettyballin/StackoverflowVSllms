from bs4 import BeautifulSoup\nimport requests\n\nurl = "https://example.com"\nresponse = requests.get(url)\nsoup = BeautifulSoup(response.content, 'html.parser')\n\n# Find the main content element\nmain_content = soup.find('div', {'class': 'main-content'})\n\n# Extract the text content\ntext_content = main_content.get_text(strip=True)