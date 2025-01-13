function collateRequestVars() {\n    // Create an empty object\n    $requestVars = new stdClass();\n\n    // Merge GET and POST arrays, POST values will overwrite GET values if keys are the same\n    $merged = array_merge($_GET, $_POST);\n\n    // Assign the merged array to the object properties\n    foreach ($merged as $key => $value) {\n        $requestVars->$key = $value;\n    }\n\n    return $requestVars;\n}\n\n// Usage\n$requestData = collateRequestVars();\n// Now $requestData contains all GET and POST variables