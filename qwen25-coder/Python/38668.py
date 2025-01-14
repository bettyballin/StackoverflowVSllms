import math\n\ndef lat_lon_to_cartesian(lat_deg, lon_deg, alt_m=0):\n    # Convert latitude and longitude from degrees to radians\n    lat_rad = math.radians(lat_deg)\n    lon_rad = math.radians(lon_deg)\n\n    # Earth radius in meters (WGS-84 parameters)\n    earth_radius = 6371000.0 + alt_m\n\n    x = earth_radius * math.cos(lat_rad) * math.cos(lon_rad)\n    y = earth_radius * math.cos(lat_rad) * math.sin(lon_rad)\n    z = earth_radius * math.sin(lat_rad)\n\n    return (x, y, z)\n\n# Example usage:\nlat_deg = 52.2296756\nlon_deg = 21.0122287\ncartesian_coords = lat_lon_to_cartesian(lat_deg, lon_deg)\nprint(cartesian_coords)