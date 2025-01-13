function find_diffs($string1, $string2) {\n    $array1 = preg_split("/\b/", $string1);\n    $array2 = preg_split("/\b/", $string2);\n    $m = count($array1);\n    $n = count($array2);\n\n    // Initialize LCS table\n    $LCS = array_fill(0, $m + 1, array_fill(0, $n + 1, 0));\n\n    // Build the LCS table\n    for ($i = 1; $i <= $m; $i++) {\n        for ($j = 1; $j <= $n; $j++) {\n            if ($array1[$i - 1] === $array2[$j - 1]) {\n                $LCS[$i][$j] = $LCS[$i - 1][$j - 1] + 1;\n            } else {\n                $LCS[$i][$j] = max($LCS[$i - 1][$j], $LCS[$i][$j - 1]);\n            }\n        }\n    }\n\n    // Trace back to find the differences\n    $i = $m;\n    $j = $n;\n    $diffs = array();\n\n    while ($i > 0 && $j > 0) {\n        if ($array1[$i - 1] === $array2[$j - 1]) {\n            $i--;\n            $j--;\n        } elseif ($LCS[$i - 1][$j] >= $LCS[$i][$j - 1]) {\n            $diffs[] = array($i - 1, $i, '-');\n            $i--;\n        } else {\n            $diffs[] = array($j - 1, $j, '+');\n            $j--;\n        }\n    }\n\n    // Handle remaining characters in $array1\n    while ($i > 0) {\n        $diffs[] = array($i - 1, $i, '-');\n        $i--;\n    }\n\n    // Handle remaining characters in $array2\n    while ($j > 0) {\n        $diffs[] = array($j - 1, $j, '+');\n        $j--;\n    }\n\n    return array($array1, $array2, array_reverse($diffs));\n}