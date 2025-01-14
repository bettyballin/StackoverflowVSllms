$response = file_get_contents($url);\n$data = simplexml_load_string($response);\n\n// Register the namespace prefix if known\n$cccNamespace = $data->getNamespaces(true)['ccc'];\n\nforeach ($data->item as $current) {\n    // Access elements with a namespace using children() method\n    $fid = (string)$current->children($cccNamespace)->fid;\n    $bid = (string)$current->children($cccNamespace)->bid;\n\n    echo "FID: $fid, BID: $bid\n";\n}