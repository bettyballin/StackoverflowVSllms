<?php\n$sql = mysql_query("SELECT * FROM comments WHERE user = 1");\n\n$rows = [];\nwhile ($row = mysql_fetch_assoc($sql)) {\n    $rows[] = $row;\n}\n\n$totalRows = count($rows);\n$i = 1;\n\nforeach ($rows as $row) {\n    echo "<p>$i. " . htmlspecialchars($row['comment']) . "</p>";\n    if ($i < $totalRows) {\n        echo '<div class="border"></div>';\n    }\n    $i++;\n}\n?>