<?php\n\nfunction findReferences($directory, $pages) {\n    $results = array_fill_keys(array_keys($pages), 0);\n\n    foreach (glob("$directory/*.php") as $file) {\n        $content = file_get_contents($file);\n        foreach ($pages as $page => $count) {\n            if (strpos($content, basename($page)) !== false || strpos($content, basename($page.'.php')) !== false) {\n                $results[$page]++;\n            }\n        }\n    }\n\n    return $results;\n}\n\n$directory = '/path/to/your/application';\n$pages = [\n    'viewacct.php' => 0,\n    'viewacct2.php' => 0,\n    'viewacct_rcw.php' => 0,\n];\n\n$references = findReferences($directory, $pages);\n\nforeach ($references as $page => $count) {\n    echo "$page is referenced $count times.\n";\n}\n\n?>