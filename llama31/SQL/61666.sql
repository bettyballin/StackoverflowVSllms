SELECT e.*, l.*\nFROM event e\nLEFT JOIN event_location el ON e.event_id = el.event_id\nLEFT JOIN location l ON el.location_id = l.location_id\nWHERE \n    (e.keywords LIKE '%hello%' OR e.keywords LIKE '%world%') AND\n    (\n        (l.location_id IS NULL) -- Events without locations\n        OR \n        (\n            l.location_id IS NOT NULL AND -- Events with locations\n            (\n                l.latitude = :user_lat AND l.longitude = :user_long -- Exact location match\n                OR \n                (\n                    -- Proximity search (adjust the distance calculation as needed)\n                    6371 * acos(sin(radians(:user_lat)) * sin(radians(l.latitude)) + cos(radians(:user_lat)) * cos(radians(l.latitude)) * cos(radians(l.longitude - :user_long))) <= :max_distance\n                )\n            )\n        )\n    );