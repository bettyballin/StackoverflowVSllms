SET @lat = 51.5074;\nSET @lon = -0.1278;\nSET @radius = 5000; -- radius in meters\n\nSELECT id, username, ST_Distance_Sphere(location, POINT(@lat, @lon)) AS distance\nFROM users\nWHERE ST_Distance_Sphere(location, POINT(@lat, @lon)) <= @radius\nORDER BY distance;