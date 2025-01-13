// Normal user modifies an event\n$eventId = 123;\n$newName = 'Updated Event Name';\n$newStartDate = '2023-03-15 14:00:00';\n\n// Insert pending change into events_pending\n$query = "INSERT INTO events_pending (event_id, name, start_date, changed_by, changed_at, status)\n          VALUES (:event_id, :name, :start_date, :changed_by, NOW(), 'pending')";\n$stmt = $pdo->prepare($query);\n$stmt->execute(['event_id' => $eventId, 'name' => $newName, 'start_date' => $newStartDate, 'changed_by' => $_SESSION['user_id']]);\n\n// Superior user approves the change\n$pendingId = 456;  // ID of the pending change\n$query = "UPDATE events SET name = :name, start_date = :start_date WHERE id = :event_id";\n$stmt = $pdo->prepare($query);\n$stmt->execute(['event_id' => $eventId, 'name' => $newName, 'start_date' => $newStartDate]);\n\n$query = "UPDATE events_pending SET status = 'approved' WHERE id = :pending_id";\n$stmt = $pdo->prepare($query);\n$stmt->execute(['pending_id' => $pendingId]);