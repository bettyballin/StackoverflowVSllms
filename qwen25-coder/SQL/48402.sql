WITH RECURSIVE DateSeries AS (\n    SELECT MIN(DATE(login_date)) AS dt FROM WebsiteLogin\n    UNION ALL\n    SELECT DATE_ADD(dt, INTERVAL 1 DAY) FROM DateSeries WHERE DATE_add(dt, INTERVAL 1 DAY) <= (SELECT MAX(DATE(login_date)) FROM WebsiteLogin)\n)\nSELECT ds.dt, COUNT(w.id) as login_count\nFROM DateSeries ds\nLEFT JOIN WebsiteLogin w ON DATE(w.login_date) = ds.dt\nGROUP BY ds.dt\nORDER BY ds.dt;