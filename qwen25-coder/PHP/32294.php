$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'your_username', 'your_password');\n$stmt = $pdo->prepare("\n    SELECT \n        s.*,\n        UNIX_TIMESTAMP(s.`date`) AS `date`,\n        COUNT(f.ID) AS favorite_count,\n        CASE WHEN fu.ID IS NOT NULL THEN 1 ELSE 0 END AS is_favored_by_user\n    FROM \n        songs s\n    LEFT JOIN \n        (SELECT FAVORITE FROM favorites WHERE USERID = :userHash) fu ON s.ID = fu.FAVORITE\n    LEFT JOIN \n        (SELECT FAVORITE, COUNT(ID) as count FROM favorites GROUP BY FAVORITE) fav_counts ON s.ID = fav_counts.FAVORITE\n    WHERE \n        s.date >= DATE_SUB(NOW(), INTERVAL 2 WEEK)\n    GROUP BY \n        s.ID\n    ORDER BY \n        s.`date` DESC;\n");\n\n$cookieHash = $_COOKIE['your_cookie_name']; // Adjust to retrieve your cookie value properly.\n$stmt->bindParam(':userHash', $cookieHash, PDO::PARAM_STR);\n$stmt->execute();\n\n$results = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\nforeach ($results as $row) {\n    // Process each row\n}