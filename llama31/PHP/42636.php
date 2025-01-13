function get_content($a, $b, $c = "00")\n{\n    // ...\n\n    $output = '';\n    while (!feof($socket)) {\n        $chunkSize = fgets($socket);\n        $chunkSize = trim($chunkSize);\n        if ($chunkSize == '') {\n            break; // end of response\n        }\n        $chunkSize = hexdec($chunkSize);\n        $chunk = '';\n        while ($chunkSize > 0) {\n            $data = fread($socket, $chunkSize);\n            $chunkSize -= strlen($data);\n            $chunk .= $data;\n        }\n        $output .= $chunk;\n        fgets($socket); // read and discard the CRLF after the chunk\n    }\n\n    return $output;\n}