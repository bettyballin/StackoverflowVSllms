import requests\n\n# Replace 'YOUR_API_KEY' with your actual Alpha Vantage API key\napi_key = 'YOUR_API_KEY'\nsymbol = 'AX-UN.TO'\nurl = f'https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol={symbol}&apikey={api_key}'\n\nresponse = requests.get(url)\ndata = response.json()\n\nprint(data)