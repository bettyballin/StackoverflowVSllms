SELECT *\nFROM zip_code\nWHERE (\n  6371 * acos(\n    sin(radians(lat)) * sin(radians($origin_lat)) +\n    cos(radians(lat)) * cos(radians($origin_lat)) *\n    cos(radians(lon) - radians($origin_lon))\n  )\n) <= $distance;