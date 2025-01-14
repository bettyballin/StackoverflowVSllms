<?php\n// Connect to SQLite database\n$db = new SQLite3('mp3_database.db');\n\n// Query to fetch songs with artists and albums\n$results = $db->query("SELECT s.Title AS Song, a.Name AS Artist, b.Title AS Album, g.Name AS Genre \n                        FROM Songs s \n                        JOIN Artists a ON s.ArtistID = a.ArtistID \n                        JOIN Albums b ON s.AlbumID = b.AlbumID \n                        JOIN Genres g ON s.GenreID = g.GenreID");\n\n// Output the results\necho "<table border='1'>";\necho "<tr><th>Song</th><th>Artist</th><th>Album</th><th>Genre</th></tr>";\nwhile ($row = $results->fetchArray(SQLITE3_ASSOC)) {\n    echo "<tr><td>{$row['Song']}</td><td>{$row['Artist']}</td><td>{$row['Album']}</td><td>{$row['Genre']}</td></tr>";\n}\necho "</table>";\n\n$db->close();\n?>