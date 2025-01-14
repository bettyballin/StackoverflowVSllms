SELECT\n    r.id AS registration_id,\n    r.event_id,\n    r.team,\n    r.status,\n    GROUP_CONCAT(DISTINCT p.id) AS people_ids,\n    GROUP_CONCAT(DISTINCT p.name) AS people_names,\n    GROUP_CONCAT(DISTINCT e.id) AS entry_ids,\n    GROUP_CONCAT(DISTINCT e.name) AS entry_names\nFROM\n    registrations r\nLEFT JOIN\n    registration_people rp ON r.id = rp.registration_id\nLEFT JOIN\n    person p ON rp.person_id = p.id\nLEFT JOIN\n    registration_entries re ON r.id = re.registration_id\nLEFT JOIN\n    entry e ON re.entry_id = e.id\nWHERE\n    r.event_id = ?\nGROUP BY\n    r.id, r.event_id, r.team, r.status