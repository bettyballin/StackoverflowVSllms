<?php\n$mysqli = new mysqli("localhost", "username", "password", "database");\n\nif ($mysqli->connect_error) {\n    die('Connect Error (' . $mysqli->connect_errno . ') ' . $mysqli->connect_error);\n}\n\n$query = "SELECT * FROM sections";\n$stmt = $mysqli->query($query);\n\n$loop = 1;\n\nwhile ($row_sections = $stmt->fetch_array()) {\n    $category = 1;\n    echo "<h3>" . htmlspecialchars($row_sections['section_name']) . " (Loop# $loop)</h3>";\n\n    $awards_query = $mysqli->query("SELECT * FROM categories WHERE section_id = $loop");\n\n    while ($categories = $awards_query->fetch_array()) {\n        $winners_query = $mysqli->query("SELECT * FROM 2009_RKR_bestof WHERE section = $loop AND category = $category ORDER BY result_level ASC");\n        echo "<h4><strong>" . htmlspecialchars($categories['category_name']) . "</strong></h4>";\n        echo "<ul class=\"winners\">";\n\n        while ($winners = $winners_query->fetch_array()) {\n            switch ($winners['result_level']) {\n                case 1:\n                    $result_level = "Platinum";\n                    break;\n                case 2:\n                    $result_level = "Gold";\n                    break;\n                case 3:\n                    $result_level = "Silver";\n                    break;\n            }\n            $anchor = $close = '';\n            if (isset($winners['url'])) {\n                $anchor = "<a href=\"http://" . htmlspecialchars($winners['url']) . "\" target=\"_blank\">";\n                $close = "</a>";\n            }\n\n            echo "<li>$anchor" . htmlspecialchars($winners['winner']) . "$close ($result_level)</li>";\n        }\n        echo '</ul>';\n        $category++;\n    }\n    $loop++;\n}\n$mysqli->close();\n?>