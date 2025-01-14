from selenium import webdriver\nfrom selenium.webdriver.common.by import By\nfrom selenium.webdriver.chrome.service import Service\nfrom webdriver_manager.chrome import ChromeDriverManager\nimport time\n\n# Setup Chrome options\noptions = webdriver.ChromeOptions()\noptions.add_argument('--headless')  # Run headless browser\noptions.add_argument('--no-sandbox')\noptions.add_argument('--disable-dev-shm-usage')\n\n# Initialize the Chrome driver\ndriver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)\n\n# Go to the specified URL\nurl = "http://example.com"  # Replace with your target URL\ndriver.get(url)\n\n# Wait for the page to load completely\ntime.sleep(5)  # You can use WebDriverWait for a more robust solution\n\n# Find the button by its ID, class, or other selector and click it\nbutton = driver.find_element(By.ID, "button-id")  # Replace with your button's selector\nbutton.click()\n\n# Wait for the click action to complete\ntime.sleep(5)  # Adjust the sleep time as needed\n\n# Take a screenshot and save it\nscreenshot_path = "screenshot.png"\ndriver.save_screenshot(screenshot_path)\n\n# Close the browser\ndriver.quit()\n\nprint(f"Screenshot saved to {screenshot_path}")