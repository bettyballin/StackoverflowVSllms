public function getXML()\n{\n    $url=$this->constructURL();\n    $ch = curl_init();\n    curl_setopt($ch, CURLOPT_URL, $url);\n    curl_setopt($ch, CURLOPT_HEADER, 0);\n    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);\n    // Set the path to your CA bundle\n    curl_setopt($ch, CURLOPT_CAINFO, '/path/to/cacert.pem');\n    \n    $xml = curl_exec($ch);\n    if ($error = curl_error($ch)) {\n        echo "Error: $error<br />\n";\n    }\n    curl_close($ch);\n    return $xml;\n}