import requests\n\ndef read_file_from_server(url):\n    try:\n        response = requests.get(url)\n        response.raise_for_status()  # Check if the request was successful\n        return response.text\n    except requests.exceptions.RequestException as e:\n        print(f"An error occurred: {e}")\n        return None\n\n# Replace 'http://example.com/file.txt' with the URL of the file you want to read\nfile_url = 'http://example.com/file.txt'\nfile_content = read_file_from_server(file_url)\n\nif file_content is not None:\n    print(file_content)