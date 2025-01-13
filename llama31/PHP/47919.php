class Graph {\n    private $adjacencyList;\n    private $nodeCount;\n\n    public function __construct($nodeCount) {\n        $this->adjacencyList = array_fill(0, $nodeCount, array());\n        $this->nodeCount = $nodeCount;\n    }\n\n    public function addEdge($from, $to, $weight) {\n        $this->adjacencyList[$from][] = array($to, $weight);\n    }\n\n    public function shortestPath($start, $end) {\n        $queue = new SplPriorityQueue();\n        $queue->insert($start, 0);\n\n        $distances = array_fill(0, $this->nodeCount, PHP_INT_MAX);\n        $distances[$start] = 0;\n\n        while (!$queue->isEmpty()) {\n            $currentNode = $queue->extract();\n            $currentDistance = $distances[$currentNode];\n\n            foreach ($this->adjacencyList[$currentNode] as $neighbor) {\n                $neighborNode = $neighbor[0];\n                $neighborWeight = $neighbor[1];\n                $newDistance = $currentDistance + $neighborWeight;\n\n                if ($newDistance < $distances[$neighborNode]) {\n                    $distances[$neighborNode] = $newDistance;\n                    $queue->insert($neighborNode, $newDistance);\n                }\n            }\n        }\n\n        return $distances[$end];\n    }\n}\n\n// Example usage:\n$graph = new Graph(5);\n$graph->addEdge(0, 1, 2);\n$graph->addEdge(0, 2, 3);\n$graph->addEdge(1, 3, 1);\n$graph->addEdge(2, 4, 2);\n\n$startNode = 0;\n$endNode = 4;\n\n$shortestPath = $graph->shortestPath($startNode, $endNode);\necho "Shortest path from $startNode to $endNode: $shortestPath";