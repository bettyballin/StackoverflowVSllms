function data_info($data)\n{\n    $bufferArray = array();\n    if ($data) {\n        while (!feof($data)) {\n            $buffer = trim(fgets($data)); // trim the newline character\n            if (file_exists($buffer)) {\n                $bufferArray[$buffer] = array(\n                    'exists' => true,\n                    'readable' => is_readable($buffer),\n                    'writable' => is_writable($buffer),\n                    'size' => filesize($buffer)\n                );\n            } else {\n                $bufferArray[$buffer] = array('exists' => false);\n            }\n        }\n        print_r($bufferArray);\n    } else {\n        echo "The file could not be opened";\n    }\n}\n\n$data = fopen("D:/xampp/htdocs/Practice/ficheros.txt", "r");\ndata_info($data);