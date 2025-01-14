SELECT \n    u.id AS user_id,\n    u.name AS user_name,\n    COUNT(p.id) AS number_of_photos,\n    COUNT(c.id) AS number_of_comments,\n    (COUNT(p.id) + COUNT(c.id)) AS total_items\nFROM \n    users u\nLEFT JOIN \n    photos p ON u.id = p.user_id\nLEFT JOIN \n    comments c ON u.id = c.user_id\nGROUP BY \n    u.id, u.name\nORDER BY \n    total_items DESC;