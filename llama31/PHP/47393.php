$username = "firstleg_floa";\n$password = "**";\n$hostname = "***1";\n$db = "firstleg_bank";\n$guildUser = strtolower('grissiom');\n\n$dbh = mysql_connect($hostname, $username, $password) or die("Unable To Connect");\n$connectDB = mysql_select_db($db, $dbh);\n$results = mysql_query("SELECT * FROM Bank where userId ='" . $guildUser . "'");\n\n$i = 0;\n$rsArr = array();\n\nwhile ($row = mysql_fetch_array($results, MYSQL_ASSOC)) {\n    $rsArr[$i]['userId'] = $row['userId'];\n    $rsArr[$i]['item'] = $row['item'];\n    $rsArr[$i]['amount'] = $row['amount'];\n    $rsArr[$i]['position'] = $row['position'];\n    $i++;\n}\n\n?>\n<table>\n    <tr><td>Item</td><td>Amount</td></tr>\n    <?php for ($x = 0; $x < $i; $x++) { ?>\n        <tr><td><?= $rsArr[$x]['item']; ?></td><td><?= $rsArr[$x]['amount']; ?></td></tr>\n    <?php } ?>\n</table>\n\n<?php\nmysql_close($dbh);\n?>