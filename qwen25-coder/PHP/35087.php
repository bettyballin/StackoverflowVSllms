function getShortName($filePath) {\n    $filePath = escapeshellarg($filePath);\n    $output = [];\n    exec("for %I in ($filePath) do @echo %~sI", $output);\n    return $output[0] ?? '';\n}\n\n$longFilePath = "C:\\Path\\To Your\\File With Spaces.txt";\n$shortName = getShortName($longFilePath);\n\necho $shortName;