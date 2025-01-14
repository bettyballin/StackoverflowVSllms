import requests\n\ndef reverse_geocode(lat, lng, api_key):\n    url = f"https://maps.googleapis.com/maps/api/geocode/json?latlng={lat},{lng}&key={api_key}"\n    response = requests.get(url)\n    if response.status_code == 200:\n        results = response.json()['results']\n        for result in results:\n            components = result['address_components']\n            city = None\n            zip_code = None\n            for component in components:\n                if 'locality' in component['types']:\n                    city = component['long_name']\n                elif 'postal_code' in component['types']:\n                    zip_code = component['long_name']\n            if city and zip_code:\n                return city, zip_code\n    return None, None\n\n# Example usage\napi_key = "YOUR_GOOGLE_MAPS_API_KEY"\nlatitude = 37.4220\nlongitude = -122.0841\ncity, zip_code = reverse_geocode(latitude, longitude, api_key)\nprint(f"City: {city}, Zip Code: {zip_code}")