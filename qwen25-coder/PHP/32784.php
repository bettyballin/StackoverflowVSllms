function prepend_proxy($matches) {\n    $url = (substr($_GET['url'], 0, 7) == 'http://') ? $_GET['url'] : "http://{$_GET['url']}";\n    $prepend = $matches[2] ? $matches[2] : $url;\n    $prepend = 'proxy2.php?url='. $prepend .'/';\n\n    return $matches[1] . $prepend . $matches[3];\n}\n\nfunction imgprepend_proxy($matches) {\n    $url = (substr($_GET['url'], 0, 7) == 'http://') ? $_GET['url'] : "http://{$_GET['url']}";\n    $prepend = $matches[2] ? $matches[2] : $url;\n    $prepend = $prepend .'/';\n\n    return $matches[1] . $prepend . $matches[3];\n}\n\n$content = 'Your HTML content here'; // Make sure to set your HTML content here\n\n$new_content = preg_replace_callback(\n    '|(href=[\'"]?)(https?://)?([^\'"\s]+[\'"]?)|i',\n    'prepend_proxy',\n    $content\n);\n\n$new_content = preg_replace_callback(\n    '|(src=[\'"]?)(https?://)?([^\'"\s]+[\'"]?)|i',\n    'imgprepend_proxy',\n    $new_content\n);