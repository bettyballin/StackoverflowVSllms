// in User.php\npublic function testConnection() {\n    $db = ConnectionManager::getDataSource('default');\n    $result = $db->query('SELECT 1');\n    debug($result);\n}