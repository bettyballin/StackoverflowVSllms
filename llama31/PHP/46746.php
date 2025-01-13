$pdo = new PDO('mysql:host=your_host;dbname=your_db', 'your_username', 'your_password');\n\n$data = file_get_contents($tempFile); // perhaps 30MB of file data, now in PHP's memory\n$hash = md5($data);\n\n$stmt = $pdo->prepare('INSERT INTO some_table SET BlobData = :blob_data, BlobHash = :blob_hash');\n$stmt->bindParam(':blob_data', $data, PDO::PARAM_LOB);\n$stmt->bindParam(':blob_hash', $hash);\n$stmt->execute();