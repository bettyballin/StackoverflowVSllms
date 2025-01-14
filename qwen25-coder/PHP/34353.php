<?php\n   session_start();\n   $session_id = session_id();\n   $user_id = 1; // This should be dynamically set to the logged-in user's ID\n\n   // Insert or Update session data\n   $stmt = $pdo->prepare("INSERT INTO user_sessions (session_id, user_id) VALUES (:session_id, :user_id)\n                            ON DUPLICATE KEY UPDATE last_activity = NOW()");\n   $stmt->execute([':session_id' => $session_id, ':user_id' => $user_id]);\n   ?>