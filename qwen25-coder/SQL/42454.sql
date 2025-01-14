SELECT w.*\nFROM Workplan w\nINNER JOIN (\n    SELECT UserID, MAX(CreatedDate) AS LatestCreatedDate\n    FROM Workplan\n    GROUP BY UserID\n) latest ON w.UserID = latest.UserID AND w.CreatedDate = latest.LatestCreatedDate;