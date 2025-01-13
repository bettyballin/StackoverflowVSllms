from selenium import webdriver\n\n# Initialize the Chrome WebDriver\noptions = webdriver.ChromeOptions()\noptions.add_argument('--headless')\ndriver = webdriver.Chrome(options=options)\n\n# Load the webpage\ndriver.get('https://example.com')\n\n# Find the elements you are interested in\nelements = driver.find_elements_by_css_selector('your-css-selector')\n\nfor element in elements:\n    location = element.location\n    size = element.size\n    coordinates = {\n        'top-left': (location['x'], location['y']),\n        'top-right': (location['x'] + size['width'], location['y']),\n        'bottom-left': (location['x'], location['y'] + size['height']),\n        'bottom-right': (location['x'] + size['width'], location['y'] + size['height'])\n    }\n    print(coordinates)\n\n# Close the WebDriver\ndriver.quit()