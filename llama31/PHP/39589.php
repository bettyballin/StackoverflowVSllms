$page = file_get_contents('http://translate.google.com/translate_t', false, $context);\n$page = iconv('ISO-8859-1', 'UTF-8', $page);