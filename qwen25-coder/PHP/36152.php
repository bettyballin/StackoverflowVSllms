$monthPart = preg_quote(($date[0] == 0) ? '' : $date[0], '/');\n$dayPart   = preg_quote(($date[2] == 0) ? '' : $date[2], '/');\n\n// Creating regex pattern without unnecessary complexity in regex itself\n$regex = "/^" . ($monthPart ? '\d?' : '') . "[/.-]?" . \n         ($dayPart ? '\d?' : '') . "[/.-]" . preg_quote($date[3], '/') . "$/";