$players = array();\n\nwhile ($homePlayerRow = mysql_fetch_array($homePlayerResult)) {\n    $players[] = $homePlayerRow['player_id'];\n}