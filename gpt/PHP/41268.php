$event_id = 1; // example event_id\n$sql = "SELECT\n            r.id AS registration_id,\n            r.event_id,\n            r.team,\n            r.status,\n            GROUP_CONCAT(DISTINCT p.id) AS people_ids,\n            GROUP_CONCAT(DISTINCT p.name) AS people_names,\n            GROUP_CONCAT(DISTINCT e.id) AS entry_ids,\n            GROUP_CONCAT(DISTINCT e.name) AS entry_names\n        FROM\n            registrations r\n        LEFT JOIN\n            registration_people rp ON r.id = rp.registration_id\n        LEFT JOIN\n            person p ON rp.person_id = p.id\n        LEFT JOIN\n            registration_entries re ON r.id = re.registration_id\n        LEFT JOIN\n            entry e ON re.entry_id = e.id\n        WHERE\n            r.event_id = ?\n        GROUP BY\n            r.id, r.event_id, r.team, r.status";\n\n$stmt = $pdo->prepare($sql);\n$stmt->execute([$event_id]);\n$registrations = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\nforeach ($registrations as &$registration) {\n    $registration['people_ids'] = explode(',', $registration['people_ids']);\n    $registration['people_names'] = explode(',', $registration['people_names']);\n    $registration['entry_ids'] = explode(',', $registration['entry_ids']);\n    $registration['entry_names'] = explode(',', $registration['entry_names']);\n}\n\nreturn $registrations;