// Assuming $site->prepare() and $site->execute() are methods for preparing and executing queries\n$stmt = $site->prepare('UPDATE `user_ips` SET `last_time` = UNIX_TIMESTAMP(), `user_agent` = ? WHERE `ip` = ? AND `userid` = ?');\n$stmt->bind_param('sii', $this->user_agent, $this->ip, $this->id);\n$stmt->execute();\n$affectedRows = $stmt->affected_rows;\nif($affectedRows == 0) {\n    $insertStmt = $site->prepare('INSERT INTO `user_ips` (`userid`, `ip`, `first_time`, `last_time`, `user_agent`) VALUES (?, ?, UNIX_TIMESTAMP(), UNIX_TIMESTAMP(), ?)');\n    $insertStmt->bind_param('iiss', $this->id, $this->ip, $this->user_agent);\n    $insertStmt->execute();\n}