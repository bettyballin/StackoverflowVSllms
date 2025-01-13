$mysqli = new mysqli("localhost", "username", "password", "database");\n\n$id = $mysqli->real_escape_string($_REQUEST['id']);\n$Section = $mysqli->real_escape_string($_REQUEST['section']);\n$Subject = $mysqli->real_escape_string($_REQUEST['subject']);\n$type = $mysqli->real_escape_string($_REQUEST['type']);\n$Start_date1 = isset($_REQUEST['startTxt']) ? $mysqli->real_escape_string($_REQUEST['startTxt']) : "";\n$Venue = isset($_REQUEST['venTxt']) ? $mysqli->real_escape_string($_REQUEST['venTxt']) : "";\n$Facilitator = isset($_REQUEST['faciTxt']) ? $mysqli->real_escape_string($_REQUEST['faciTxt']) : "";\n$Level = isset($_REQUEST['lvlLst']) ? $mysqli->real_escape_string($_REQUEST['lvlLst']) : "";\n$Date1 = $mysqli->real_escape_string($_REQUEST['date1']);\n\nif (isset($_REQUEST['EDIT'])) {\n    $stmt = $mysqli->prepare("UPDATE service SET Start_date=?, Venue=?, Facilitator=? WHERE ServiceID=?");\n    $stmt->bind_param('sssi', $Date1, $Venue, $Facilitator, $id);\n    \n    if (!$stmt->execute()) {\n        die('Error: ' . $stmt->error);\n    }\n\n    echo '<script type="text/javascript">';\n    echo 'alert("Changes have been saved!");';\n    echo 'window.location="Admin_RecSchedMapLst.php";';\n    echo '</script>';\n\n    $stmt->close();\n    $mysqli->close();\n}