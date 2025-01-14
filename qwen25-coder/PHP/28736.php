public function getConfigurationValue($field)\n{\n    $pdo = new PDO('mysql:host=your_host;dbname=your_db', 'username', 'password');\n    $stmt = $pdo->prepare("SELECT `cfg_value` FROM `ls_config` WHERE `cfg_name` = :field");\n    $stmt->execute(['field' => $field]);\n    \n    $result = $stmt->fetchColumn();\n    return isset($result) ? htmlspecialchars($result) : null;\n}