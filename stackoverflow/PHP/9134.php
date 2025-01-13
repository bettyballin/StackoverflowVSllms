function createUrlFriendlyName($name) // $name must be an UTF-8 encoded string\n{\n    $name=mb_convert_encoding(trim($name), 'HTML-ENTITIES', 'UTF-8');\n    $name=preg_replace(\n        array('/&szlig;/', '/&(..)lig;/', '/&([aouAOU])uml;/', '/&(.)[^;]*;/', '/\W/'),\n        array('ss', '$1', '$1e', '$1', '-'),\n        $name);\n    $name=preg_replace('/-{2,}/', '-', $name);\n    return trim($name, '-');\n}