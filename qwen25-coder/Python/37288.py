import gpxpy\nfrom geopy.distance import geodesic\n\ndef calculate_distance(gpx_file):\n    with open(gpx_file, 'r') as f:\n        gpx = gpxpy.parse(f)\n\n    total_distance = 0.0\n    for track in gpx.tracks:\n        for segment in track.segments:\n            points = segment.points\n            for i in range(1, len(points)):\n                start_point = (points[i-1].latitude, points[i-1].longitude)\n                end_point = (points[i].latitude, points[i].longitude)\n                total_distance += geodesic(start_point, end_point).kilometers\n\n    return total_distance\n\n# Usage\ngpx_file_path = 'your_track.gpx'\ndistance_km = calculate_distance(gpx_file_path)\nprint(f"Total distance covered: {distance_km} km")