$xpath->registerNamespace("php", "http://php.net/xpath");\n$query = $xpath->query('//*[self::input|self::select|self::textarea][@name=php:functionString("htmlspecialchars", "' . $field . '")]');