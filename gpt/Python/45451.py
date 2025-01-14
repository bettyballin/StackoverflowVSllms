import requests\nimport xml.etree.ElementTree as ET\n\n# Make a GET request to the RESTful web service\nresponse = requests.get('https://example.com/api/resource')\n\n# Check if the request was successful\nif response.status_code == 200:\n    # Parse the XML content\n    root = ET.fromstring(response.content)\n\n    # Iterate through the XML elements and process them\n    for child in root:\n        print(child.tag, child.attrib, child.text)\nelse:\n    print(f"Failed to retrieve data: {response.status_code}")