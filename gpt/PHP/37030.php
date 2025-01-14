// First query\n$query1 = "\nSELECT ARTICLE_NO, USERNAME, ACCESSSTARTS, ARTICLE_NAME,\n       DATE_FORMAT(STR_TO_DATE(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), '%d %m %Y') AS shortDate\nFROM AUCTIONS1\nWHERE UPPER(ARTICLE_NAME) LIKE '%x%'\nORDER BY STR_TO_DATE(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), ARTICLE_NO\nLIMIT 0, 10";\n\n// Execute first query\n$result1 = mysqli_query($conn, $query1);\n\n// Fetch the current record's ARTICLE_NO\n$current_article_no = $result1 ? mysqli_fetch_assoc($result1)['ARTICLE_NO'] : null;\n\n// Second query to fetch the next record\nif ($current_article_no) {\n    $query2 = "\n    SELECT ARTICLE_NO\n    FROM AUCTIONS1\n    WHERE (STR_TO_DATE(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), ARTICLE_NO) >\n          (SELECT STR_TO_DATE(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), ARTICLE_NO\n           FROM AUCTIONS1\n           WHERE ARTICLE_NO = $current_article_no)\n    ORDER BY STR_TO_DATE(ACCESSSTARTS, '%d/%m/%Y %k:%i:%s'), ARTICLE_NO\n    LIMIT 1";\n\n    // Execute second query\n    $result2 = mysqli_query($conn, $query2);\n    $next_article_no = $result2 ? mysqli_fetch_assoc($result2)['ARTICLE_NO'] : null;\n}