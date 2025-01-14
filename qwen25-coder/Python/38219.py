import requests\n\n# Define your API key here\napi_key = 'YOUR_API_KEY'\n\n# Define origin and destination\norigin = 'City A, Country'\ndestination = 'City B, Country'\n\n# Make the request URL\nurl = f"https://maps.googleapis.com/maps/api/directions/json?origin={origin}&destination={destination}&key={api_key}"\n\n# Send the request\nresponse = requests.get(url)\n\n# Get the data in JSON format\ndata = response.json()\n\n# Extract route information (e.g., duration and distance)\nroutes = data['routes']\nif routes:\n    legs = routes[0]['legs']\n    if legs:\n        first_leg = legs[0]\n        print(f"Distance: {first_leg['distance']['text']}")\n        print(f"Duration: {first_leg['duration']['text']}")\n\n# Extract route coordinates\noverview_polyline = routes[0]['overview_polyline']\npoints = overview_polyline.get('points')\nprint("Route Coordinates:", points)