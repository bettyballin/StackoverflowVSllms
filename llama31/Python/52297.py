from bs4 import BeautifulSoup\nimport requests\n\n# Send a GET request\nurl = 'http://www.example.com'\nresponse = requests.get(url)\n\n# If the GET request is successful, the status code will be 200\nif response.status_code == 200:\n    # Get the content of the response\n    page_content = response.content\n\n    # Create a BeautifulSoup object and specify the parser\n    soup = BeautifulSoup(page_content, 'html.parser')\n\n    # Now you can use soup to scrape the page\n    # For example, to find all the links on the page:\n    links = soup.find_all('a')\n    for link in links:\n        print(link.get('href'))