uasort($files, function($a, $b) {\n    return $a->getSize() - $b->getSize();\n});