$images_dir = '/path/to/images';\n//this folder must be writeable by the server\n$backup = '/path/to/backup';\n$zip_file = $backup.'/backup.zip';\n\nif ($handle = opendir($images_dir))  \n{\n    $zip = new ZipArchive();\n\n    if ($zip->open($zip_file, ZipArchive::CREATE)!==TRUE) \n    {\n        exit("cannot open <$zip_file>\n");\n    }\n\n    while (false !== ($file = readdir($handle))) \n    {\n        $zip->addFile($images_dir.'/'.$file);\n        echo "$file\n";\n    }\n    closedir($handle);\n    echo "numfiles: " . $zip->numFiles . "\n";\n    echo "status:" . $zip->status . "\n";\n    $zip->close();\n    echo 'Zip File:'.$zip_file . "\n";\n}