// test3.php\n<?php\n    // Assuming $row2 is populated correctly and contains "ARTICLE_DESC"\n    header("Content-Type: text/html");\n    echo "<html><body>";\n    echo $row2["ARTICLE_DESC"]; // This should be safe if $row2["ARTICLE_DESC"] is properly sanitized!\n    echo "</body></html>";\n?>