# Import necessary libraries\nfrom selenium import webdriver\n\n# Set up the Firefox driver (ensure geckodriver is in PATH)\ndriver = webdriver.Firefox()\n\n# Open a web page for testing\ndriver.get('http://example.com')\n\n# More interactions can go here...\n\n# Close the browser window after test finishes\ndriver.quit()