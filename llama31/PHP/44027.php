$site = strtolower($_POST['site']);\n$site = str_replace($illegal, '', $site);\n\n$stmt = $mysqli->prepare("INSERT INTO `$find` VALUES (NULL, ?, 1, 0)");\n$stmt->bind_param("s", $site);\n$stmt->execute();