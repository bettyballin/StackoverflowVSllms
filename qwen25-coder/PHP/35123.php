<?php\n$keywords = explode(' ', $_GET['search']);\n$query_parts = [];\n\nforeach ($keywords as $keyword) {\n    // Use LIKE in both columns and join them with OR.\n    $query_parts[] = "(blog_title LIKE '%$keyword%' OR blog_content LIKE '%$keyword%')";\n}\n\n// Join all conditions with AND to require all keywords.\n$conditions = implode(' AND ', $query_parts);\n\n$sql_blog = "SELECT * FROM blog WHERE $conditions ORDER BY blog_title";\n$sql_links = "SELECT * FROM links WHERE $conditions ORDER BY link_title";\n$sql_pages = "SELECT * FROM pages WHERE $conditions ORDER BY page_title";\n\n// Example for executing the blog query\n$result_blog = mysql_query($sql_blog) or die(mysql_error());\nwhile ($row = mysql_fetch_assoc($result_blog)) {\n    // Process your results here\n}\n\n// You should also handle links and pages similarly.\n?>