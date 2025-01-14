from selenium import webdriver\nfrom selenium.webdriver.firefox.options import Options\nfrom bs4 import BeautifulSoup\n\n# Setup headless browser\noptions = Options()\noptions.headless = True  # Run in headless mode (no GUI)\ndriver = webdriver.Firefox(options=options)\n\n# Open a webpage and get its HTML content\nurl = 'http://example.com'\ndriver.get(url)\n\n# Get the page source after rendering\npage_source = driver.page_source\n\n# Parse with BeautifulSoup\nsoup = BeautifulSoup(page_source, 'html.parser')\n\n# Example: Extracting all links\nlinks = [a['href'] for a in soup.find_all('a', href=True)]\n\nprint(links)\n\n# Quit the WebDriver\ndriver.quit()