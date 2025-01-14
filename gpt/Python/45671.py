import math\n\ndef haversine(lat1, lon1, lat2, lon2):\n    # Radius of the Earth in kilometers\n    R = 6371.0\n    \n    # Convert latitude and longitude from degrees to radians\n    lat1_rad = math.radians(lat1)\n    lon1_rad = math.radians(lon1)\n    lat2_rad = math.radians(lat2)\n    lon2_rad = math.radians(lon2)\n    \n    # Differences in coordinates\n    dlat = lat2_rad - lat1_rad\n    dlon = lon2_rad - lon1_rad\n    \n    # Haversine formula\n    a = math.sin(dlat / 2)**2 + math.cos(lat1_rad) * math.cos(lat2_rad) * math.sin(dlon / 2)**2\n    c = 2 * math.atan2(math.sqrt(a), math.sqrt(1 - a))\n    \n    # Distance in kilometers\n    distance = R * c\n    \n    return distance\n\n# Example usage\nlat1, lon1 = 52.2296756, 21.0122287  # Point 1: Warsaw, Poland\nlat2, lon2 = 41.8919300, 12.5113300  # Point 2: Rome, Italy\n\ndistance = haversine(lat1, lon1, lat2, lon2)\nprint(f"Distance: {distance} km")