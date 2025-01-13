import requests\n\n# Ask for the product name\nproduct_name = input("Enter the product name: ")\n\n# Set the URL of your PHP page\nurl = "http://example.com/your-php-page.php"\n\n# Set the POST data\ndata = {"product_name": product_name}\n\n# Send the POST request\nresponse = requests.post(url, data=data)\n\n# Check if the request was successful\nif response.status_code == 200:\n    print("Product name sent successfully")\nelse:\n    print("Failed to send product name")