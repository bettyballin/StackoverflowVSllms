WITH RankedAccess AS (\n    SELECT \n        t.id AS thing_id,\n        COALESCE(a_thing.access, a_group.access) AS access,\n        ROW_NUMBER() OVER (PARTITION BY t.id ORDER BY CASE WHEN a_thing.type = 'thing' THEN 1 ELSE 2 END) as rn\n    FROM things t\n    LEFT JOIN access a_thing ON a_thing.user_id = 1 AND a_thing.type = 'thing' AND a_thing.object_id = t.id\n    LEFT JOIN access a_group ON a_group.user_id = 1 AND a_group.type = 'group' AND a_group.object_id = t.group_id\n)\nSELECT thing_id, access\nFROM RankedAccess\nWHERE rn = 1\nORDER BY thing_id;