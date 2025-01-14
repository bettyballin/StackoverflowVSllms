$searchTerm = $_GET['search_term'];  // Assume this is where your search form sends the input\n\n$stmt = $pdo->prepare("\n    SELECT \n        u.fname, \n        u.lname, \n        u.role, \n        u.username, \n        r.building AS ra_building, \n        r.room AS ra_room, \n        r.region AS ra_region,\n        a.office_bldg AS ac_office_bldg, \n        a.office_num AS ac_office_num\n    FROM \n        users u\n    LEFT JOIN \n        ra_ca r ON u.username = r.username\n    LEFT JOIN \n        area_coord a ON u.username = a.username\n    WHERE \n        (u.fname LIKE :searchTerm OR u.lname LIKE :searchTerm)\n        OR r.building LIKE :searchTerm\n        OR r.region = :regionOrOfficeNum  -- If region is numeric\n        OR a.office_num = :regionOrOfficeNum;  -- If office number is numeric\n");\n\n$pattern = '%' . $searchTerm . '%';\n$stmt->bindParam(':searchTerm', $pattern, PDO::PARAM_STR);\n$stmt->bindParam(':regionOrOfficeNum', intval($searchTerm));  // Convert to int for numeric fields\n\n$stmt->execute();\n$results = $stmt->fetchAll(PDO::FETCH_ASSOC);\n\nforeach ($results as $row) {\n    print_r($row);  // Display each result\n}