import requests\n\n# URL of the open API endpoint\napi_url = "https://api.example.com/data"\n\n# Making a GET request to fetch data\nresponse = requests.get(api_url)\n\n# Check if the request was successful\nif response.status_code == 200:\n    data = response.json()\n    print("Data fetched successfully:", data)\nelse:\n    print("Failed to fetch data. Status code:", response.status_code)