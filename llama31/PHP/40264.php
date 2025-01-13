$fp = fopen('path/to/file.log', 'r');\n$lastPos = 0;\n\nwhile (true) {\n    $line = fgets($fp);\n    if ($line === false) {\n        // no new data, wait 1 second before checking again\n        sleep(1);\n        continue;\n    }\n    echo $line;\n    $lastPos = ftell($fp);\n}