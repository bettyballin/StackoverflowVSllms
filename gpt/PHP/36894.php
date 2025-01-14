function parseString($input) {\n    // Find the third occurrence of "000000"\n    $pos1 = strpos($input, "000000");\n    if ($pos1 === false) return false;\n    $pos2 = strpos($input, "000000", $pos1 + 6);\n    if ($pos2 === false) return false;\n    $pos3 = strpos($input, "000000", $pos2 + 6);\n    if ($pos3 === false) return false;\n    \n    // Grab the first half and compare its hash to the next 20 bytes\n    $firstHalf = substr($input, 0, $pos3);\n    $hash = substr($input, $pos3 + 6, 20);\n    if (hash('sha256', $firstHalf) !== $hash) return false;\n\n    // Parse the 9th byte through the next "000000"\n    $dataStartPos = $pos3 + 26; // After the hash\n    $nextPos = strpos($input, "000000", $dataStartPos);\n    if ($nextPos === false) return false;\n    $data = substr($input, $dataStartPos, $nextPos - $dataStartPos);\n\n    // Grab the next 19 bytes after that\n    $remainingStartPos = $nextPos + 6;\n    $remainingBytes = substr($input, $remainingStartPos, 19);\n\n    // Split into 8, toss 1, and 8 bytes\n    $first8Bytes = substr($remainingBytes, 0, 8);\n    $second8Bytes = substr($remainingBytes, 9, 8);\n\n    // Do some other stuff to convert those two 8 byte strings into dates\n    $date1 = date('Y-m-d', strtotime($first8Bytes));\n    $date2 = date('Y-m-d', strtotime($second8Bytes));\n\n    return [\n        'firstHalf' => $firstHalf,\n        'hash' => $hash,\n        'data' => $data,\n        'firstDate' => $date1,\n        'secondDate' => $date2,\n    ];\n}\n\n$input = "your_input_string_here";\n$result = parseString($input);\n\nif ($result !== false) {\n    print_r($result);\n} else {\n    echo "Parsing failed.";\n}