# Install nexmo-python\npip install nexmo\n\n# Send an SMS using Nexmo's Python library\nimport nexmo\n\nclient = nexmo.Client(key="your_api_key", secret="your_api_secret")\n\nresponse = client.send_message({\n    "from": "your_nexmo_number",\n    "to": "+1234567890",\n    "text": "Hello from Linux!"\n})