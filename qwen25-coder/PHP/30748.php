// Sample array of stdClass objects\n$array = [\n    (object) ['type' => 'node', 'sid' => 158, 'score' => 0.059600525242489],\n    (object) ['type' => 'node', 'sid' => 247, 'score' => 0.059600525242489]\n];\n\n// Custom comparison function\nfunction compareByScoreDescending($a, $b) {\n    return $b->score <=> $a->score; // spaceship operator for PHP 7+\n}\n\n// Sorting the array\nusort($array, 'compareByScoreDescending');\n\n// Output sorted array\nprint_r($array);