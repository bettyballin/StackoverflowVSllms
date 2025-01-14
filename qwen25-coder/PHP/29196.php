<?php\nsession_start();\n\nif (!isset($_POST['textFile']) || !isset($_SESSION['serverURL'])) {\n    echo 0;\n    exit;\n}\n\n$fileName = $_POST['textFile'];\n$serverURL = $_SESSION['serverURL'];\n\n// Use cURL for HTTP request\n$ch = curl_init();\ncurl_setopt($ch, CURLOPT_URL, "$serverURL/fileReader.php?textFile=" . urlencode($fileName));\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\n$result = curl_exec($ch);\n\nif (curl_errno($ch)) {\n    echo 'Error:' . curl_error($ch);\n} else {\n    echo $result;\n}\n\ncurl_close($ch);\n?>