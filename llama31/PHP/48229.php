$query = mysql_query("..."); // the query above\nwhile ($row = mysql_fetch_assoc($query)) {\n  if (!isset($current_category) || $row['category_name'] != $current_category) {\n    echo "<li><h2>{$row['category_name']}</h2>";\n    $current_category = $row['category_name'];\n  }\n  echo "{$row['username']} wrote {$row['text']} on {$row['created_at']}<br>";\n}