SELECT \n  s.id, \n  s.classDate, \n  s.instructor, \n  COALESCE(e.enrolled, 0) AS enrolled,\n  COALESCE(w.waitlist, 0) AS waitlist\nFROM \n  schedule s\n  LEFT JOIN (SELECT scheduleId, COUNT(*) AS enrolled FROM enrolled GROUP BY scheduleId) e\n    ON s.id = e.scheduleId\n  LEFT JOIN (SELECT scheduleId, COUNT(*) AS waitlist FROM waitlist GROUP BY scheduleId) w\n    ON s.id = w.scheduleId;