// Your original array\n$array = [\n    'testuri/abc' => ['label' => 'abc', 'weight' => 5],\n    'testuri/abd' => ['label' => 'abd', 'weight' => 2],\n    'testuri/dess' => ['label' => 'dess', 'weight' => 2],\n    'testuri/gdm' => ['label' => 'gdm', 'weight' => 2],\n    'testuri/abe' => ['label' => 'abe', 'weight' => 2],\n    'testuri/esy' => ['label' => 'esy', 'weight' => 2],\n    'testuri/rdx' => ['label' => 'rdx', 'weight' => 3],\n    'testuri/tfc' => ['label' => 'tfc', 'weight' => 3],\n];\n\n// Sort the array by weight in descending order\nuasort($array, function ($a, $b) {\n    return $b['weight'] <=> $a['weight'];\n});\n\n// Get the top 5 elements\n$topFive = array_slice($array, 0, 5);\n\nprint_r($topFive);