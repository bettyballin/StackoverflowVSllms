$stmt = $mysqli->prepare("SELECT \n  s.*, \n  UNIX_TIMESTAMP(`date`) AS `date`, \n  f.userid as favoritehash\nFROM \n  songs s\nLEFT JOIN \n  favorites f\nON \n  f.favorite = s.id\n  AND f.userid = ?");\n$stmt->bind_param("s", $userhash);\n$stmt->execute();\n$result = $stmt->get_result();