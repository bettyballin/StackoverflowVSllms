<?php\ninclude "../../inc/config.inc.php";\n$temp  = explode("_", $_REQUEST['element_id']);\n$field = $temp[0];\n$id    = $temp[1];\n$textboxval = stripslashes(mysqli_real_escape_string($conn, preg_replace('/[\$]/',"",$_REQUEST["update_value"])));\n\n// Update all existing rows to have status 0\n$updateQuery = "UPDATE notes SET status = '0' WHERE c_id = '$id'";\nmysqli_query($conn, $updateQuery);\n\n// Insert the new row with status 1\n$insertQuery = "INSERT INTO notes ($field, status, date, c_id) VALUES ('$textboxval', '1', NOW(), '$id')";\nmysqli_query($conn, $insertQuery);\n\necho($_REQUEST['update_value']);\n?>