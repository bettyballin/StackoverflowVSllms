-- Example using MySQL\n    SELECT id, name, address, latitude, longitude,\n           (6371 * acos(cos(radians(:user_lat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:user_lng)) + sin(radians(:user_lat)) * sin(radians(latitude)))) AS distance\n    FROM branches\n    HAVING distance < :radius\n    ORDER BY distance\n    LIMIT :limit;