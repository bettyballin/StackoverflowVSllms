function countUppercase($string) {\n     return preg_match_all(/\b[A-Z][A-Za-z0-9]+\b/, $string)\n}\n\ncountUppercase("Hello good Sir"); // 2