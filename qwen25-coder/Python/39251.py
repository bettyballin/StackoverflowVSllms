from selenium import webdriver\nfrom selenium.webdriver.common.by import By\n\n# Set up the WebDriver (make sure to download the appropriate driver for your browser)\ndriver = webdriver.Chrome()\n\n# Navigate to the website\ndriver.get("https://example.com/login")\n\n# Find the username and password fields, fill them out and submit the form\nusername_field = driver.find_element(By.ID, "username")\npassword_field = driver.find_element(By.ID, "password")\nsubmit_button = driver.find_element(By.ID, "login-button")\n\nusername_field.send_keys("testuser")\npassword_field.send_keys("testpass")\nsubmit_button.click()\n\n# Close the browser after testing\ndriver.quit()