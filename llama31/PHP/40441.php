$sql = mysql_query("SELECT body FROM comments");\n\nwhile ($r = mysql_fetch_assoc($sql)) {\n   $body .= $r['body'] . "\n"; // add a newline character after each comment\n}\n\necho nl2br($body); // use nl2br to convert newline characters to HTML breaks