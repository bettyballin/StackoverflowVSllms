require_once('nusoap.php');\n\n$server = new soap_server();\n$server->configureWSDL('filetransfer', 'urn:filetransfer');\n\nfunction receiveFile($fileBytes) {\n    // Save the file to disk\n    $filePath = 'uploads/' . date('YmdHis') . '.bin';\n    $fileHandle = fopen($filePath, 'wb');\n    fwrite($fileHandle, $fileBytes);\n    fclose($fileHandle);\n\n    return 'File received and saved to: ' . $filePath;\n}\n\n$server->register('receiveFile', array('fileBytes' => 'xsd:string'), array('return' => 'xsd:string'));\n$server->service(isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '');