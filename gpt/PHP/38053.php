<?php\nif ($_GET) {\n    $userid = $_GET['userid'];\n\n    // Prepare the first query\n    $stmt = $db->prepare("SELECT * FROM `tbl_user` WHERE `userid` = ?");\n    $stmt->bind_param("s", $userid);\n    $stmt->execute();\n    $result = $stmt->get_result();\n    $current = $result->fetch_array(MYSQLI_ASSOC);\n\n    // Prepare the second query\n    $stmt = $db->prepare("SELECT * FROM `tbl_perms` WHERE `userid` = ?");\n    $stmt->bind_param("s", $userid);\n    $stmt->execute();\n    $result = $stmt->get_result();\n    $currentperms = $result->fetch_array(MYSQLI_ASSOC);\n\n    // Debugging output\n    echo "Current User: ";\n    print_r($current);\n    echo "Current Permissions: ";\n    print_r($currentperms);\n\n    // Check if the userid is 1\n    if ($current['userid'] == "1") {\n        echo " selected ";\n    }\n\n    // Check the newapp column value\n    echo "newapp value: " . $currentperms['newapp'];\n}\n?>