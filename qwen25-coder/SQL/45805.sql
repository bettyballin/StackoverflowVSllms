SELECT COUNT(*) AS Count, SUM(Age) AS TotalAge\nFROM (\n    SELECT availables.bookdate AS Date, DATEDIFF(CURDATE(), availables.updated_at) as Age\n    FROM availables\n    INNER JOIN rooms ON availables.room_id = rooms.id\n    WHERE availables.bookdate BETWEEN '2009-06-25' AND DATE_ADD('2009-06-25', INTERVAL 4 DAY)\n      AND rooms.hostel_id = 5094\n    GROUP BY availables.bookdate\n) AS subquery;