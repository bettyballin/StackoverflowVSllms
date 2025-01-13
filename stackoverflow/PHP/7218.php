function fileGetLine($filename, $line) {\n    if (!is_file($filename) || !is_readable($filename)) {\n        // invalid file name or not readable\n        return false;\n    }\n    if (!is_int($line)) {\n        // invalid line number\n        return false;\n    }\n    $lines = file($filename);\n    $lineCount = count($lines);\n    if ($line < 0) {\n        // negative line number, count from end\n        $line = $lineCount + $line;\n    }\n    if ($line < 0 || $line >= $lineCount) {\n        // line number out of bounds\n        return false;\n    }\n    return $lines[$line];\n}\n\nsession_start();\necho fileGetLine('text/'.basename($_POST['textFile']).'.txt', -1);