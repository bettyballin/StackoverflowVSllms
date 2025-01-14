<?php\nerror_reporting(E_ALL);\n\n$cmd = $_REQUEST["cmd"] ?? die("Invalid URL");\n$pk  = $_GET["pk"]    ?? null;\n\n$checkboxes = isset($_POST['checkboxes']) ? $_POST['checkboxes'] : [];\n$checkfield = in_array('field', $checkboxes) ? '1' : '0';\n\n$con = mysqli_connect("localhost", "user", "", "db") or die ("Can't connect to MySQL Server. Errorcode: %s\n". mysqli_connect_error());\n$con->set_charset("utf8");\n\n$stmt = $con->prepare("SELECT saleid, field FROM STATUS WHERE saleid = ?");\n$stmt->bind_param("i", $pk);\n$stmt->execute();\n$result = $stmt->get_result();\n$row = $result->fetch_assoc();\n\nif ($row) {\n    // If record exists\n    $saleid = $row['saleid'];\n    $checkfield = $row['field'];\n}\n\nif($cmd == "submitinfo") {\n    if (!$saleid) {\n        $statusQuery = "INSERT INTO STATUS (saleid, field) VALUES (?, ?)";\n    } else {\n        $statusQuery = "UPDATE STATUS SET field = ? WHERE saleid = ?";\n    }\n    \n    if ($stmt = $con->prepare($statusQuery)) {\n        $stmt->bind_param("is", $pk, $checkfield);\n        $stmt->execute();\n        $stmt->close();\n        echo "Update successful!";\n    } else {\n        print_r($con->error);\n    }\n} elseif($cmd == "EditStatusData") {\n    echo "<form name=\"statusForm\" action=\"test.php?pk=$pk\" method=\"post\">\n            <h1>Editing information for Auction No: $pk</h1>\n            <input type=\"checkbox\" name=\"checkboxes[]\" value=\"field\" ".($checkfield == '1' ? 'checked' : '')." />\n            <label for=\"field\">Test</label><br />\n            <input type=\"hidden\" name=\"cmd\" value=\"submitinfo\" />\n            <input name=\"Submit\" type=\"submit\" value=\"submit\" />\n         </form>";\n}\n\nmysqli_close($con);\n?>