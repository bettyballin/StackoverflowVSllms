$sinus = function($x) use (&$sinus) {\n    if ($x <= 0.1) {\n        return $x;\n    } else {\n        return (function($x) {\n            return 3 * $x - 4 * $x * $x * $x;\n        })($sinus($x / 3));\n    }\n};\n\necho $sinus(172.0);