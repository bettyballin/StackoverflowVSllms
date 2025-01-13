<?php\n$handle = popen('curl -o '.VIDEOPATH.$fileName.'.flv '.$url.' 2>&1', 'rb'); // make sure it's saved to the videos\n\n$pattern = '/\s+([0-9]{1,3})%/'; // Regular expression to match percentage\n\nwhile(!feof($handle)) {\n    $line = fgets($handle, 4096); // Get a line from the input handle\n    echo '<br>Line: '.$line.'<br>';\n    \n    if (preg_match($pattern, $line, $matches)) {\n        $percentage = $matches[1]; // Extract the percentage value\n        echo 'Progress: '.$percentage.'%<br>';\n        // Optionally write the percentage to a file\n        fwrite($fh, $percentage."\r\n");\n    }\n}\n\npclose($handle);\n?>