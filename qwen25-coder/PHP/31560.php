function isImage($url) {\n    $params = array('http' => array(\n        'method' => 'HEAD'\n    ));\n    $ctx = stream_context_create($params);\n    $fp = @fopen($url, 'rb', false, $ctx);\n    \n    if (!$fp) return false;  // URL issue or no response\n\n    $metaData = stream_get_meta_data($fp);\n    fclose($fp);\n\n    if ($metaData === false || !isset($metaData['wrapper_data'])) {\n        return false;  // Problem reading meta data\n    }\n\n    foreach ($metaData['wrapper_data'] as $header) {\n        if (stripos($header, 'Content-Type: image') === 0) {  // Check case-insensitive start of header\n            return true;\n        }\n    }\n\n    return false;  // No image content type found\n}