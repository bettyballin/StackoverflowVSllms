SELECT \n    u.email,\n    CASE WHEN p.user_id IS NOT NULL THEN p.code END AS password_code,\n    CASE WHEN p.user_id IS NOT NULL THEN p.expires END AS expires\nFROM \n    users u\nLEFT JOIN \n    password_resets p ON u.id = p.user_id AND u.username = :username;