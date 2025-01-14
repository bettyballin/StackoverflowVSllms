from selenium import webdriver\nfrom selenium.webdriver.common.by import By\nimport time\n\n# Initialize the WebDriver (e.g., Chrome)\ndriver = webdriver.Chrome()\n\n# Navigate to a web page\ndriver.get("http://example.com/login")\n\n# Find elements and interact with them\nusername_field = driver.find_element(By.ID, "username")\npassword_field = driver.find_element(By.ID, "password")\n\n# Input values into the form fields\nusername_field.send_keys("your_username")\npassword_field.send_keys("your_password")\n\n# Submit the form\npassword_field.submit()\n\n# Wait for a while to see the result (This is just an example wait; use WebDriverWait in production)\ntime.sleep(10)\n\n# Close the browser\ndriver.quit()