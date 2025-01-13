from pyproj import Proj, transform\n\n# Define the projections\nwgs84 = Proj(init='epsg:4326')  # WGS84\nch1903 = Proj(init='epsg:21781')  # Swiss Grid (CH 1903)\n\n# Define the input latitude and longitude\nlat = 51.5074  # Latitude for London\nlon = -0.1278  # Longitude for London\n\n# Convert the coordinates to Swiss Grid\nx, y = transform(wgs84, ch1903, lon, lat)\n\n# Define the bounds of Swiss Grid (CH 1903)\nmin_x, max_x = 420000, 900000\nmin_y, max_y = 30000, 350000\n\n# Check if the coordinates are within the bounds\nif min_x <= x <= max_x and min_y <= y <= max_y:\n    print("The point is within the bounds of the Swiss Grid coordinate system.")\nelse:\n    print("The point is outside the bounds of the Swiss Grid coordinate system.")