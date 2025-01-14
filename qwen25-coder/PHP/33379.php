function transliterateWithIconv($string) {\n    return str_replace([' ', 'ß'], ['-', 'ss'], iconv('UTF-8', 'ASCII//TRANSLIT//IGNORE', $string));\n}\n\n$input = "Café Münchner";\necho transliterateWithIconv($input); // Output: Cafe-Munchner