<?php\nfunction heapSort(&$a, $count) {\n    heapify($a, $count);\n\n    $end = $count - 1;\n    while ($end > 0) {\n        list($a[$end], $a[0]) = array($a[0], $a[$end]);\n        $end--;\n        siftDown($a, 0, $end);\n    }\n}\n\nfunction heapify(&$a, $count) {\n    $start = floor(($count - 2) / 2);\n\n    while ($start >= 0) {\n        siftDown($a, $start, $count - 1);\n        $start--;\n    }\n}\n\nfunction siftDown(&$a, $start, $end) {\n    $root = $start;\n\n    while ($root * 2 + 1 <= $end) { // While the root has at least one child\n        $child = $root * 2 + 1;       // left child\n\n        if ($child + 1 <= $end && $a[$child] < $a[$child + 1]) {\n            $child++; // right child if it's larger\n        }\n\n        if ($a[$root] < $a[$child]) { // swap if out of order\n            list($a[$child], $a[$root]) = array($a[$root], $a[$child]);\n            $root = $child; // continue sifting down the child now\n        } else {\n            return;\n        }\n    }\n}\n\n$a = Array(3, 1, 5, 2);\nheapSort($a, count($a));\nprint_r($a);\n?>