$fileName = $_POST['textFile'];\n$url = $_SESSION['serverURL']."fileReader.php?textFile=$fileName";\n\n$ch = curl_init($url);\ncurl_setopt($ch, CURLOPT_RETURNTRANSFER, true);\ncurl_setopt($ch, CURLOPT_TIMEOUT, 3); // Set a timeout of 3 seconds\n$response = curl_exec($ch);\ncurl_close($ch);\n\necho $response;