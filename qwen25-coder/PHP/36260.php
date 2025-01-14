function buildTree(array $categories) {\n    $tree = [];\n    $refs = [];\n\n    foreach ($categories as &$category) {\n        // Reference to each item by its CategoryID\n        $refs[$category['CategoryID']] =& $category;\n        // If the ParentID is 0, it means this category has no parent (it's a root node)\n        if ($category['ParentID'] == 0) {\n            $tree[] =& $category;\n        } else {\n            // Otherwise, set it as a child of its parent\n            if (!isset($refs[$category['ParentID']]['Children'])) {\n                $refs[$category['ParentID']]['Children'] = [];\n            }\n            $refs[$category['ParentID']]['Children'][] =& $category;\n        }\n    }\n\n    return $tree;\n}\n\n// Example usage:\n$data = [\n    ['CategoryID' => 1, 'ParentID' => 0, 'CategoryName' => 'Default Parent', 'lt' => 1, 'rt' => 14, 'tree_depth' => 1],\n    ['CategoryID' => 8, 'ParentID' => 1, 'CategoryName' => 'SysAdmin', 'lt' => 2, 'rt' => 7, 'tree_depth' => 2],\n    ['CategoryID' => 2, 'ParentID' => 8, 'CategoryName' => 'Linux', 'lt' => 3, 'rt' => 4, 'tree_depth' => 3],\n    ['CategoryID' => 3, 'ParentID' => 8, 'CategoryName' => 'Windows', 'lt' => 5, 'rt' => 6, 'tree_depth' => 3],\n    ['CategoryID' => 5, 'ParentID' => 1, 'CategoryName' => 'Code', 'lt' => 8, 'rt' => 13, 'tree_depth' => 2],\n    ['CategoryID' => 6, 'ParentID' => 5, 'CategoryName' => 'PHP', 'lt' => 9, 'rt' => 10, 'tree_depth' => 3],\n    ['CategoryID' => 7, 'ParentID' => 5, 'CategoryName' => 'Perl', 'lt' => 11, 'rt' => 12, 'tree_depth' => 3],\n];\n\n$tree = buildTree($data);\nprint_r($tree);