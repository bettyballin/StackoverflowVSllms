SELECT * FROM Posts WHERE UserID NOT IN (SELECT ID FROM Users);