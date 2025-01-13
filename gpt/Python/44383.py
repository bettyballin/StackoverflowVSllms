import requests\n   from bs4 import BeautifulSoup\n\n   # URL of the webpage\n   url = "https://www.example.com"\n\n   # Send a GET request to the webpage\n   response = requests.get(url)\n\n   # Parse the HTML content using BeautifulSoup\n   soup = BeautifulSoup(response.content, "html.parser")\n\n   # Find and print the title tag content\n   page_title = soup.title.string\n   print("Page Title:", page_title)