$data = simplexml_load_string($xmlFile);\nforeach ($data->item as $key => $current) {\n    // Check if the current item has a thumbnail child\n    if (isset($current->thumbnail)) {\n        $url = (string)$current->thumbnail['url'];\n        $height = (int)$current->thumbnail['height'];\n        $width = (int)$current->thumbnail['width'];\n\n        echo "URL: $url, Height: $height, Width: $width\n";\n    }\n}