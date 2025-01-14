<?php\n\nfunction highlightDifferences($string1, $string2) {\n    $length1 = strlen($string1);\n    $length2 = strlen($string2);\n    $maxLength = max($length1, $length2);\n    $differences = '';\n\n    for ($i = 0; $i < $maxLength; $i++) {\n        $char1 = isset($string1[$i]) ? $string1[$i] : '';\n        $char2 = isset($string2[$i]) ? $string2[$i] : '';\n\n        if ($char1 !== $char2) {\n            // Start of difference\n            if (strpos($differences, '[') === false || $differences[strlen($differences) - 1] === ']') {\n                $differences .= '[';\n            }\n            // Add differing character from string 2\n            $differences .= $char2;\n        } else {\n            // End of difference and back to normal characters\n            if (strpos($differences, '[') !== false && $differences[strlen($differences) - 1] !== ']') {\n                $differences .= ']';\n            }\n            // Add character from string 2 or 1 (since they are the same)\n            $differences .= $char2;\n        }\n    }\n\n    // Close last bracket if not closed\n    if (strpos($differences, '[') !== false && substr($differences, -1) !== ']') {\n        $differences .= ']';\n    }\n\n    return $differences;\n}\n\n$string1 = "The brown fox jumps over the lazy dog";\n$string2 = "The quick brown fox jumped over the lazy dog";\n\n$result = highlightDifferences($string1, $string2);\necho $result;\n\n?>