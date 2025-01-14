SELECT \n    s.id AS scheduleId,\n    s.classDate,\n    s.instructor,\n    COALESCE((SELECT COUNT(e.id) FROM enrolled e WHERE e.scheduleId = s.id), 0) AS enrolled,\n    COALESCE((SELECT COUNT(w.id) FROM waitlist w WHERE w.scheduleId = s.id), 0) AS waitlisted\nFROM \n    schedule AS s;