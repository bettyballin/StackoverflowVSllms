$stmt = $pdo->prepare('UPDATE forum SET replys = replys - 1 WHERE fid = :fid');\n$stmt->execute([':fid' => $id]);