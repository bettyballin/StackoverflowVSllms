SELECT \n    COUNT(*) AS Count, \n    SUM(Age) AS SUM\nFROM (\n    SELECT \n        availables.bookdate AS Date, \n        DATEDIFF(NOW(), availables.updated_at) AS Age\n    FROM \n        availables\n    INNER JOIN \n        rooms ON availables.room_id = rooms.id\n    WHERE \n        availables.bookdate BETWEEN '2009-06-25' AND DATE_ADD('2009-06-25', INTERVAL 4 DAY)\n        AND rooms.hostel_id = 5094\n    GROUP BY \n        availables.bookdate\n) AS subquery;