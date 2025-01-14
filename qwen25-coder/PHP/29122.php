function countLinesInFile($filename) {\n    $handle = fopen($filename, "r");\n    if (!$handle) {\n        throw new Exception("Unable to open file: " . $filename);\n    }\n\n    $lineCount = 0;\n    // Buffer size (adjust as necessary)\n    $bufferSize = 4096;\n\n    while (($buffer = fread($handle, $bufferSize)) !== false) {\n        // Count lines in the current buffer\n        $linesInBuffer = substr_count($buffer, "\n");\n        // Ensure we don't double-count partial line at end of buffer if file ends with \n\n        if (substr($buffer, -1) === "\n") {\n            $linesInBuffer++;\n        }\n        $lineCount += $linesInBuffer;\n    }\n\n    fclose($handle);\n    return $lineCount;\n}\n\ntry {\n    $filename = 'largefile.txt';\n    echo "Total lines: " . countLinesInFile($filename) . PHP_EOL;\n} catch (Exception $e) {\n    echo $e->getMessage() . PHP_EOL;\n}