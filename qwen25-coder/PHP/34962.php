<?php\n$sql = mysqli_query($conn, "SELECT * FROM comments WHERE user = 1");\n$totalRows = mysqli_num_rows($sql);\n$i = 1;\n\nwhile ($row = mysqli_fetch_assoc($sql)) {\n    echo "<p>$i. " . htmlspecialchars($row['comment']) . "</p>";\n\n    // Check if it's not the last row\n    if ($i < $totalRows) {\n        echo "<div class=\"border\"></div>";\n    }\n\n    $i++;\n}\n?>