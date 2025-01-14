// Given: $pages array with id, title, parent_id\n\nfunction buildTree(array $elements) {\n    $marked = array(); // Keeps track of visited nodes\n    $parentIdColumn = 'pag_parent';\n    $idColumn = 'pag_id';\n\n    foreach ($elements as &$element) {\n        if (!isset($element[$parentIdColumn])) {\n            continue;\n        }\n        if (!array_key_exists($element[$parentIdColumn], $elementsById)) {\n            $elementsById[$element[$parentIdColumn]] = [];\n        }\n        $elementsById[$element[$parentIdColumn]][] =& $element;\n    }\n\n    function buildRecursiveList(array &$nodes, &$html, $depth = 0) {\n        if (empty($nodes)) return;\n\n        // Create <ul> on recursion level start\n        if ($depth >= 0) {\n            $html .= str_repeat("\t", $depth) . "<ul>" . PHP_EOL;\n        }\n\n        foreach ($nodes as &$node) {\n            $id = $node[$idColumn];\n            $title = $node['pag_title'];\n            // Create <li>\n            $html .= str_repeat("\t", $depth) . "<li>{$title}";\n\n            // Check and recurse into children\n            if (isset($elementsById[$id])) {\n                buildRecursiveList($elementsById[$id], $html, $depth + 1);\n            }\n\n            // Close the <li> tag\n            $html .= str_repeat("\t", $depth) . "</li>" . PHP_EOL;\n\n        }\n        // Create </ul> on recursion end level\n        if ($depth >= 0) {\n            $html .= str_repeat("\t", $depth) . "</ul>" . PHP_EOL;\n        }\n    }\n\n    $html = '';\n    buildRecursiveList($elementsById[0], $html); // Assuming '0' represents root parent_id (adjust as necessary)\n    unset($element, $nodes);\n    return $html;\n}\n\n// Usage:\n$treeHtml = buildTree($pages);\necho $treeHtml;