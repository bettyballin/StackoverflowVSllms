from selenium import webdriver\nfrom selenium.webdriver.firefox.options import Options\nfrom bs4 import BeautifulSoup\n\n# Set up headless Firefox\noptions = Options()\noptions.headless = True\ndriver = webdriver.Firefox(options=options)\n\n# URL to be fetched\nurl = "https://example.com"\n\n# Fetch the page\ndriver.get(url)\n\n# Get the page source\nhtml = driver.page_source\n\n# Parse the page using BeautifulSoup\nsoup = BeautifulSoup(html, 'html.parser')\n\n# Example: Print the title of the page\nprint(soup.title.string)\n\n# Clean up and close the browser\ndriver.quit()