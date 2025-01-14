import requests\nimport time\n\n# Simulate data collection and sending to server\nwhile True:\n    # Simulated data\n    data = {'key1': 'value1', 'key2': 'value2'}\n    \n    response = requests.post('http://localhost:5000/collect_data', json=data)\n    print("Server Response:", response.json())\n    \n    time.sleep(5)  # Wait for a while before sending more data