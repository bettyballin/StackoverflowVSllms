from bs4 import BeautifulSoup\n\n# Assuming 'html_content' is your webpage content\nsoup = BeautifulSoup(html_content, 'html.parser')\n\n# Example of extracting links (modify as per your needs)\nlinks = soup.find_all('a')\n\n# Extract and print the text contents of each link\nfor link in links:\n    if link.contents:  # Check if there are contents\n        # Convert Unicode to ASCII\n        ascii_contents = [str(c).encode('ascii', 'ignore') for c in link.contents]\n        print(ascii_contents)