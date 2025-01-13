from selenium import webdriver\n\n# Start the browser\ndriver = webdriver.Chrome()\n\n# Navigate to your webpage\ndriver.get('https://yourwebsite.com')\n\n# Execute JavaScript to collect performance metrics\nperformance_data = driver.execute_script(\n    "return window.performance.getEntriesByType('resource')"\n)\n\n# Process performance metrics\nfor resource in performance_data:\n    print(f"Name: {resource['name']}")\n    print(f"Start Time: {resource['startTime']}")\n    print(f"Duration: {resource['duration']}")\n    print(f"Transfer Size: {resource['transferSize']}")\n    print('---')\n\n# Close the browser\ndriver.quit()