header('Content-type: text/html; charset=UTF-8') ;\n\n/**\n * Encodes HTML safely for UTF-8. Use instead of htmlentities. \n *\n * @param string $var \n * @return string \n */\nfunction html_encode($var)\n{\n    return htmlentities($var, ENT_QUOTES, 'UTF-8');\n}