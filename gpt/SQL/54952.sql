SELECT \n    m.id AS media_id,\n    m.uri AS media_uri,\n    GROUP_CONCAT(CASE WHEN p.role = 1 THEN p.name END) AS actor,\n    GROUP_CONCAT(CASE WHEN p.role = 2 THEN p.name END) AS artist,\n    GROUP_CONCAT(CASE WHEN p.role = 3 THEN p.name END) AS publisher,\n    GROUP_CONCAT(CASE WHEN p.role = 4 THEN p.name END) AS writer,\n    GROUP_CONCAT(CASE WHEN p.role = 5 THEN p.name END) AS director,\n    -- Add more roles as needed up to role 10\n    GROUP_CONCAT(CASE WHEN p.role = 10 THEN p.name END) AS other_role\nFROM \n    media m\nLEFT JOIN \n    media_to_people mp ON m.id = mp.media_id\nLEFT JOIN \n    people p ON mp.people_id = p.id\nGROUP BY \n    m.id, m.uri