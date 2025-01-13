<?php\nfunction array_path_exists(&$array, $path, $separator = '/')\n{\n    $a =& $array;\n    $paths = explode($separator, $path);\n    $i = 0;\n    foreach ($paths as $p) {\n        if (isset($a[$p])) {\n            if ($i == count($paths) - 1) {\n                return TRUE;\n            }\n            elseif(is_array($a[$p])) {\n                $a =& $a[$p];\n            }\n            else {\n                return FALSE;\n            }\n        }\n        else {\n            return FALSE;\n        }\n        $i++;\n    }\n}\n\n// Test\n$test = array(\n    'foo' => array(\n        'bar' => array(\n            'baz' => 1\n            )\n        ),\n    'bar' => 1\n    );\n\necho array_path_exists($test, 'foo/bar/baz');\n\n?>