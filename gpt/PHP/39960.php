$url = "http://search.twitter.com/search.json?q=&ands=&phrase=&ors=&nots=RT%2C+%40&tag=andyasks&lang=all&from=amcafee&to=&ref=&near=&within=15&units=mi&since=&until=&rpp=50";\n$contents = file_get_contents($url);\n$decode = json_decode($contents, true);\n$connection = mysql_connect("your_host", "your_username", "your_password");\nmysql_select_db("your_database", $connection);\n\nforeach($decode['results'] as $current) {\n    $text = mysql_real_escape_string($current['text']);\n    $created_at = mysql_real_escape_string($current['created_at']);\n    $query = "INSERT IGNORE INTO andyasks (questions, date, user) VALUES ('$text', '$created_at', 'Andy')";\n    \n    if(preg_match("/\?/", $current['text'])) {\n        mysql_query($query);\n    }\n}\n\nmysql_close($connection);