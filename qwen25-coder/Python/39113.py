from selenium import webdriver\n\n# Initialize the Chrome WebDriver\ndriver = webdriver.Chrome()\n\n# Open a web page\ndriver.get("http://www.example.com")\n\n# Get the title of the page and print it\nprint("Page Title:", driver.title)\n\n# Close the browser\ndriver.quit()