function get_ucs2_codepoints($str) {\n    $codePoints = array();\n    // Ensure the string is treated as UTF-8\n    if (mb_strlen($str, 'UTF-8') !== false) {\n        for ($i = 0; $i < mb_strlen($str, 'UTF-8'); $i++) {\n            $char = mb_substr($str, $i, 1, 'UTF-8');\n            // Get the Unicode code point\n            $ord = unpack('N', mb_convert_encoding($char, 'UCS-4BE', 'UTF-8'));\n            $ord = array_shift($ord);\n            if ($ord <= 0xFFFF) {\n                // For BMP characters (planes 1 - Basic Multilingual Plane)\n                $hex_codepoint = str_pad(dechex($ord), 4, "0", STR_PAD_LEFT);\n            } else {\n                // For characters outside the BMP\n                $ord -= 0x10000;\n                $lowSurrogate = ($ord & 0x3ff) + 0xDC00;\n                $highSurrogate = (($ord >> 10) & 0x3ff) + 0xD800;\n                $hex_codepoint = str_pad(dechex($highSurrogate), 4, "0", STR_PAD_LEFT) . ' ' . str_pad(dechex($lowSurrogate), 4, "0", STR_PAD_LEFT);\n            }\n            $codePoints[] = $hex_codepoint;\n        }\n    } else {\n        return false; // Not a valid UTF-8 string\n    }\n    return implode(' ', $codePoints);\n}\n\n// Example usage:\n$inputString = "hello";\necho get_ucs2_codepoints($inputString); // Outputs: 0068 0065 006c 006c 006f