<?php\n$template = '<td>{{address}}</td><td>{{fixDate}}</td><td>{{measureDate}}</td><td>{{builder}}</td>';\n$replace = array(\n    'address' => '123 Main St',\n    'fixDate' => '2021-06-01',\n    'measureDate' => '2021-06-02',\n    'builder' => 'John Doe'\n);\n\n// Define a callback function that will be used for the replacement\nfunction replace_callback($matches) {\n    global $replace;\n    $key = $matches[1]; // This is the captured group from the regex\n    return isset($replace[$key]) ? $replace[$key] : $matches[0];\n}\n\n// Use preg_replace_callback with a regex to find {{var}} patterns\n$result = preg_replace_callback('/\{\{(\w+)\}\}/', 'replace_callback', $template);\n\necho $result;\n?>