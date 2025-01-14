from selenium import webdriver\nfrom selenium.webdriver.common.by import By\nimport time\n\n# Open a browser (make sure you have the chromedriver installed and in path)\ndriver = webdriver.Chrome()\n\ntry:\n    # Navigate to the search page\n    driver.get('http://pubs.acs.org/search/advanced')\n\n    # Fill out the form\n    driver.find_element(By.NAME, 'author').send_keys('Author Name')\n    driver.find_element(By.NAME, 'title').send_keys('Article Title')\n    \n    # Submit the form (you need to adjust the selector)\n    driver.find_element(By.CLASS_NAME, 'submit-button').click()\n\n    time.sleep(5)  # Give some time to load results\n\n    # Extract DOIs from results\n    for link in driver.find_elements(By.CLASS_NAME, 'article-link'):\n        article_url = link.get_attribute('href')\n        driver.get(article_url)\n        \n        doi_tag = driver.find_element(By.XPATH, "//meta[@name='DC.identifier']")\n        if doi_tag:\n            print(doi_tag.get_attribute('content'))\nfinally:\n    # Close the browser\n    driver.quit()