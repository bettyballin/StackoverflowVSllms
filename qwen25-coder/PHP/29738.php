function getCommonHomepageContent($pdo) {\n    $stmt = $pdo->prepare("SELECT config_value FROM website_config WHERE config_key = 'common_homepage_content'");\n    $stmt->execute();\n    return $stmt->fetchColumn();\n}