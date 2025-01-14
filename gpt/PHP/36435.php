<?php\nfunction buildTree($nodes) {\n    $tree = [];\n    $indexedNodes = [];\n\n    // Index nodes by their ID\n    foreach ($nodes as $node) {\n        $indexedNodes[$node['id']] = $node;\n        $indexedNodes[$node['id']]['children'] = [];\n    }\n\n    // Build the tree\n    foreach ($indexedNodes as $id => &$node) {\n        $ancestors = explode(',', $node['ancestors']);\n        array_pop($ancestors); // Remove the node itself\n        if (!empty($ancestors)) {\n            $parentID = array_pop($ancestors); // Get the immediate parent\n            if (isset($indexedNodes[$parentID])) {\n                $indexedNodes[$parentID]['children'][] = &$node;\n            }\n        } else {\n            $tree[] = &$node;\n        }\n    }\n\n    return $tree;\n}\n\n// Build the tree\n$tree = buildTree($nodes);\n\n// Function to print the tree for visualization\nfunction printTree($tree, $level = 0) {\n    foreach ($tree as $node) {\n        echo str_repeat("-", $level) . " Node " . $node['id'] . "\n";\n        if (!empty($node['children'])) {\n            printTree($node['children'], $level + 1);\n        }\n    }\n}\n\n// Print the tree\nprintTree($tree);\n?>