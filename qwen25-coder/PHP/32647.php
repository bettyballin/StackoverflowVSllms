<?php\nif ($_SERVER['HTTP_HOST'] == 'legacy.example.com') {\n    $query_params = array("fromLegacy" => "true");\n    $queryString = http_build_query($query_params);\n    header('Location: https://new.example.com/?' . $queryString, true, 302);\n    exit();\n}\n?>