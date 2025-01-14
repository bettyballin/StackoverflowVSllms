import requests\nfrom requests.auth import HTTPBasicAuth\n\ndef activate_appliance(mac_address, server_url):\n    headers = {'Content-Type': 'application/json'}\n    data = {\n        "mac": mac_address  # Ensure this is properly sanitized\n    }\n    \n    try:\n        response = requests.post(\n            server_url,\n            json=data,\n            auth=HTTPBasicAuth('your_username', 'your_password'),\n            headers=headers\n        )\n        \n        if response.status_code == 200:\n            print("Activation successful:", response.json())\n        else:\n            print("Failed to activate, status code:", response.status_code)\n    \n    except requests.exceptions.RequestException as e:\n        print(f"An error occurred: {e}")\n\n# Example usage\nmac_address = "00:1A:2B:3C:4D:5E"\nserver_url = "https://your-server.com/activate"\nactivate_appliance(mac_address, server_url)