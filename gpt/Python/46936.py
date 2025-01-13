import requests\nfrom bs4 import BeautifulSoup\n\ndef analyze_website(url):\n    response = requests.get(url)\n    soup = BeautifulSoup(response.text, 'html.parser')\n\n    # Extract images\n    images = [img['src'] for img in soup.find_all('img')]\n\n    # Extract links\n    links = [a['href'] for a in soup.find_all('a', href=True)]\n\n    # Guess CMS\n    cms_guess = 'Unknown'\n    if 'wp-content' in response.text:\n        cms_guess = 'WordPress'\n    elif 'Joomla' in response.text:\n        cms_guess = 'Joomla'\n    # Add more CMS detection logic as needed\n\n    report = {\n        'images': images,\n        'links': links,\n        'cms_guess': cms_guess\n    }\n\n    return report\n\n# Example usage\nurl = 'http://example.com'\nreport = analyze_website(url)\nprint(report)