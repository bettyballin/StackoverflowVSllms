if ($handle = opendir($path)) {\n    $files = [];\n    while (false !== ($entry = readdir($handle))) {\n        if ($entry[0] !== '.' && is_file($path . DIRECTORY_SEPARATOR . $entry)) {\n            $files[] = $entry;\n        }\n    }\n    closedir($handle);\n    \n    sort($files); // Sort the array in alphabetical order\n\n    foreach ($files as $szFilename) {\n        // Do stuff with each file\n    }\n}