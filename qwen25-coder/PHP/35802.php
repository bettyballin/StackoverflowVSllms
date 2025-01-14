function numberToWords($number) {\n    $hyphen      = '-';\n    $conjunction = ' and ';\n    $separator   = ', ';\n    $negative    = 'negative ';\n    $decimal     = ' point ';\n    $dictionary  = array(\n        0                   => 'zero',\n        1                   => 'one',\n        2                   => 'two',\n        3                   => 'three',\n        4                   => 'four',\n        5                   => 'five',\n        6                   => 'six',\n        7                   => 'seven',\n        8                   => 'eight',\n        9                   => 'nine',\n        10                  => 'ten',\n        11                  => 'eleven',\n        12                  => 'twelve',\n        13                  => 'thirteen',\n        14                  => 'fourteen',\n        15                  => 'fifteen',\n        16                  => 'sixteen',\n        17                  => 'seventeen',\n        18                  => 'eighteen',\n        19                  => 'nineteen',\n        20                  => 'twenty',\n        30                  => 'thirty',\n        40                  => 'forty',\n        50                  => 'fifty',\n        60                  => 'sixty',\n        70                  => 'seventy',\n        80                  => 'eighty',\n        90                  => 'ninety',\n        100                 => 'hundred',\n        1000                => 'thousand',\n        1000000             => 'million',\n        1000000000          => 'billion',\n        1000000000000       => 'trillion',\n        1000000000000000    => 'quadrillion',\n        1000000000000000000 => 'quintillion'\n    );\n\n    if (!is_numeric($number)) {\n        return false;\n    }\n\n    if ($number < 0) {\n        return $negative . numberToWords(abs($number));\n    }\n\n    $string = $fraction = null;\n\n    if (strpos($number, '.') !== false) {\n        list($number, $fraction) = explode('.', $number);\n    }\n\n    switch (true) {\n        case $number < 21:\n            $string = $dictionary[$number];\n            break;\n        case $number < 100:\n            $tens   = ((int) ($number / 10)) * 10;\n            $units  = $number % 10;\n            $string = $dictionary[$tens];\n            if ($units) {\n                $string .= $hyphen . $dictionary[$units];\n            }\n            break;\n        case $number < 1000:\n            $hundreds  = $number / 100;\n            $remainder = $number % 100;\n            $string = $dictionary[$hundreds] . ' ' . $dictionary[100];\n            if ($remainder) {\n                $string .= $conjunction . numberToWords($remainder);\n            }\n            break;\n        default:\n            $baseUnit = pow(1000, floor(log($number, 1000)));\n            $numBaseUnits = (int) ($number / $baseUnit);\n            $remainder = $number % $baseUnit;\n            $string = numberToWords($numBaseUnits) . ' ' . $dictionary[$baseUnit];\n            if ($remainder) {\n                $string .= $separator . numberToWords($remainder);\n            }\n            break;\n    }\n\n    if (null !== $fraction && is_numeric($fraction)) {\n        $string .= $decimal;\n        $words = array();\n        foreach (str_split((string) $fraction) as $number) {\n            $words[] = $dictionary[$number];\n        }\n        $string .= implode(' ', $words);\n    }\n\n    return $string;\n}\n\n// Example usage\necho numberToWords(27); // Outputs: twenty-seve