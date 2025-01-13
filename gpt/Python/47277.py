from selenium import webdriver\nfrom selenium.webdriver.chrome.service import Service\nfrom selenium.webdriver.common.by import By\nfrom selenium.webdriver.chrome.options import Options\nimport time\n\n# Setup Chrome options\nchrome_options = Options()\nchrome_options.add_argument("--headless")  # Ensure GUI is off\nchrome_options.add_argument("--no-sandbox")\nchrome_options.add_argument("--disable-dev-shm-usage")\n\n# Set path to chromedriver as per your configuration\nwebdriver_service = Service('/path/to/chromedriver')\n\n# Choose Chrome Browser\ndriver = webdriver.Chrome(service=webdriver_service, options=chrome_options)\n\n# URL to be loaded\nurl = "http://example.com"\n\n# Load the page\ndriver.get(url)\n\n# Wait for JavaScript to execute (adjust the time as necessary)\ntime.sleep(5)\n\n# Get the page source after JavaScript has executed\nrendered_html = driver.page_source\n\n# Print the rendered HTML\nprint(rendered_html)\n\n# Close the browser\ndriver.quit()