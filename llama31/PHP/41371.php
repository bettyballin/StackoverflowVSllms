$unsortedObjectArray = array(\n    (object)array('weight' => 3),\n    (object)array('weight' => 1),\n    (object)array('weight' => 2),\n);\n\nusort($unsortedObjectArray, function($a, $b) {\n    return $a->weight - $b->weight;\n});\n\n$sortedObjectArray = $unsortedObjectArray;