<?php\n   $site_id = 1; // example site ID\n   $hit_type = 'in'; // or 'out'\n\n   $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n   $stmt = $pdo->prepare("INSERT INTO hits (site_id, hit_type) VALUES (:site_id, :hit_type)");\n   $stmt->execute(['site_id' => $site_id, 'hit_type' => $hit_type]);\n   ?>