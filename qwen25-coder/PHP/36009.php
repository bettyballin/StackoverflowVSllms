function findAllChildren($nodes, $parentId) {\n    $children = [];\n\n    foreach ($nodes as $node) {\n        if ($node['parent_id'] === $parentId) {\n            $children[] = $node['id'];\n            // Recursively add children's children\n            $children = array_merge($children, findAllChildren($nodes, $node['id']));\n        }\n    }\n\n    return $children;\n}\n\n// Sample data\n$menuItems = [\n    ['id' => 0, 'parent_id' => 7],\n    ['id' => 0, 'parent_id' => 4],\n    ['id' => 4, 'parent_id' => 9],\n    ['id' => 4, 'parent_id' => 14],\n    ['id' => 4, 'parent_id' => 16],\n    ['id' => 9, 'parent_id' => 6]\n];\n\n// Correct the sample data to valid id-parent_id pairs\n$menuItems = [\n    ['id' => 7, 'parent_id' => 0],\n    ['id' => 4, 'parent_id' => 0],\n    ['id' => 9, 'parent_id' => 4],\n    ['id' => 14, 'parent_id' => 4],\n    ['id' => 16, 'parent_id' => 4],\n    ['id' => 6, 'parent_id' => 9]\n];\n\n// Find all children of node with id 4\n$childrenOfFour = findAllChildren($menuItems, 4);\n\nprint_r($childrenOfFour); // Output should be Array ( [0] => 9 [1] => 6 [2] => 14 [3] => 16 )