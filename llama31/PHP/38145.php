$stmt = $db->prepare('\n    SELECT zipcode, ST_Distance_Sphere(POINT(:longitude, :latitude), POINT(longitude, latitude)) AS distance\n    FROM zipcodes\n    WHERE ST_Distance_Sphere(POINT(:longitude, :latitude), POINT(longitude, latitude)) <= :radius\n    ORDER BY distance\n');\n$stmt->bindParam(':latitude', $coords['latitude']);\n$stmt->bindParam(':longitude', $coords['longitude']);\n$stmt->bindParam(':radius', $radius);\n$stmt->execute();