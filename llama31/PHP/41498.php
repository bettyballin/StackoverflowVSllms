$data = json_decode(stripslashes($this->_request->getParam('object')), true);\nif (!is_array($data) || !isset($data['ne']) || !isset($data['sw'])) {\n  // Handle invalid input data\n  exit;\n}\n$nelat = floatval($data['ne'][0]);\n$nelng = floatval($data['ne'][1]);\n$swlat = floatval($data['sw'][0]);\n$swlng = floatval($data['sw'][1]);\n// ...