<table>\n<?php\n    // Assuming $result is the result of your MySQL query\n    $result = mysqli_query($conn, "SELECT color FROM myTable");\n    \n    if ($result) {\n        $counter = 0;\n        echo "<tr>"; // Start the first row\n\n        while ($row = mysqli_fetch_assoc($result)) {\n            $color = htmlspecialchars($row['color'], ENT_QUOTES, 'UTF-8'); // Sanitize output\n            echo "<td>$color</td>";\n            $counter++;\n\n            // Check if we need to start a new row after every 3 columns\n            if ($counter % 3 == 0) {\n                echo "</tr><tr>"; // Close current row and start a new one\n            }\n        }\n\n        // If the last row doesn't have 3 columns, it needs to be closed.\n        if ($counter % 3 != 0) {\n            echo "</tr>";\n        }\n    } else {\n        echo "<tr><td>Error fetching data</td></tr>";\n    }\n?>\n</table>