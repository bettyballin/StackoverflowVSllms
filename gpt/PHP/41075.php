// Compress data before storing\n$compressedBody = gzcompress($emailBody);\n\n// Store in the database\n$stmt = $pdo->prepare("INSERT INTO emails (sender, receiver, subject, body) VALUES (?, ?, ?, ?)");\n$stmt->execute([$sender, $receiver, $subject, $compressedBody]);\n\n// Retrieve and decompress data\n$stmt = $pdo->prepare("SELECT body FROM emails WHERE id = ?");\n$stmt->execute([$emailId]);\n$compressedBody = $stmt->fetchColumn();\n$emailBody = gzuncompress($compressedBody);