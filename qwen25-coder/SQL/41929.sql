SELECT name,\n       ST_Distance_sphere(POINT(-71.35368, 42.290763), location_point) / 1000 AS distance_in_km\nFROM locations\nWHERE active = 1 AND MBRContains(LineString(Point(-71.35368 + 0.1/ (111.045 * cos(RADIANS(42.290763))),\n                                                   42.290763 + 0.1 / 111.045),\n                                      Point(-71.35368 - 0.1/ (111.045 * cos(RADIANS(42.290763))),\n                                                   42.290763 - 0.1 / 111.045)), \n                              location_point)\nHAVING distance_in_km < 10\nORDER BY distance_in_km;