if (!(substr($res, 0, 6) == 'Failed')) {\n    $xml = simplexml_load_string($res);\n    if ($xml === false) {\n        // Handle invalid XML error\n        echo 'Error parsing XML';\n    } else {\n        $imagelink = (string) $xml->image_link;\n        $_SESSION['shack_link'] = $imagelink;\n        echo 'done';\n    }\n}