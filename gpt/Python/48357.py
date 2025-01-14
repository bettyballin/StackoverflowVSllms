from selenium import webdriver\nfrom lxml import etree\n\n# Initialize WebDriver (assuming you have already installed the appropriate driver)\ndriver = webdriver.Chrome()\n\n# Navigate to the desired page\ndriver.get('http://example.com')\n\n# Get the page source and parse it with lxml\npage_source = driver.page_source\nhtml_parser = etree.HTMLParser()\ntree = etree.fromstring(page_source, html_parser)\n\n# Function to generate XPath for an element\ndef get_xpath(element):\n    return tree.getpath(element)\n\n# Get all elements on the page\nall_elements = driver.find_elements_by_xpath('//*')\n\n# Generate XPath for each element\nall_xpaths = [get_xpath(etree.ElementBase(element.get_attribute('outerHTML'))) for element in all_elements]\n\n# Print or process the XPath list\nfor xpath in all_xpaths:\n    print(xpath)\n\n# Close the browser\ndriver.quit()