// Assuming $db_table, $username, $timeofentry, and $ip are properly sanitized\n\n// Insert or update the row\n$query = "INSERT INTO `$db_table` (username, live, datetime, ip, bump_count) \n          VALUES ('$username', '1', '$timeofentry', '$ip', 1)\n          ON DUPLICATE KEY UPDATE live=VALUES(live), datetime=VALUES(datetime), ip=VALUES(ip), bump_count=bump_count+1";\n\nmysql_query($query);