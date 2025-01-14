require_once('pclzip.lib.php'); // Include the pclzip library\n\nfunction openZip($file_to_open) {\n    global $target;\n    global $unique_folder;\n\n    $archive = new PclZip($file_to_open);\n    if ($archive->extract(PCLZIP_OPT_PATH, $target . $unique_folder) == 0) {\n        die("Error : " . $archive->errorInfo(true));\n    } else {\n        unlink($file_to_open); // Delete the zip file after extraction\n    }\n}