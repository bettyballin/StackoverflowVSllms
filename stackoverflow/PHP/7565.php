$string = "Look on http://www.google.com";\n$string = preg_replace(\n              "~[[:alpha:]]+://[^<>[:space:]]+[[:alnum:]/]~",\n              "<a href=\"\\0\">\\0</a>", \n              $string);