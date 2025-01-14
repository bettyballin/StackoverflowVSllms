function sinus($x) {\n    if ($x <= 0.1) {\n        return $x;\n    } else {\n        $lambda = function($sinX) use(&$sinus) {\n            return (3 * $sinX - 4 * $sinX * $sinX * $sinX);\n        };\n        return $lambda(sinus($x / 3));\n    }\n}\n\necho sinus(172.0);