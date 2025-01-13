function shortestPath($graph, $start, $end) {\n    $queue = array($start);\n    $visited = array($start => true);\n    $parent = array(); // to reconstruct the path\n\n    while (!empty($queue)) {\n        $node = array_shift($queue);\n        if ($node == $end) {\n            // reconstruct the path\n            $path = array();\n            while ($node != $start) {\n                $path[] = $node;\n                $node = $parent[$node];\n            }\n            $path[] = $start;\n            return array_reverse($path);\n        }\n        foreach ($graph[$node] as $linkedNode) {\n            if (!isset($visited[$linkedNode])) {\n                $visited[$linkedNode] = true;\n                $parent[$linkedNode] = $node;\n                $queue[] = $linkedNode;\n            }\n        }\n    }\n    return null; // no path found\n}\n\n// example graph representation\n$graph = array(\n    0 => array(5, 10, 15, 20),\n    1 => array(30, 40, 50),\n    // ...\n    5 => array(10, 24, 36),\n    // ...\n);\n\n$start = 5;\n$end = 80;\n$path = shortestPath($graph, $start, $end);\nif ($path) {\n    echo "Shortest path: " . implode("->", $path) . "\n";\n} else {\n    echo "No path found.\n";\n}