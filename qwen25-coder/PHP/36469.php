<?php\n\nclass QueryCache {\n    private $cacheDir;\n\n    public function __construct($directory) {\n        // Ensure the cache directory exists and is writable\n        if (!is_dir($directory)) {\n            mkdir($directory, 0755, true);\n        }\n        $this->cacheDir = rtrim($directory, '/') . '/';\n    }\n\n    public function getCachedQueryResult($query, $ttl = 3600) { // TTL in seconds\n        $hash = md5($query);\n        $filePath = $this->cacheDir . $hash;\n\n        if (file_exists($filePath)) {\n            $time = filemtime($filePath);\n            if ((time() - $time) < $ttl) {\n                return unserialize(file_get_contents($filePath));\n            }\n        }\n\n        // Query the database and get result\n        $dbResult = $this->queryDatabase($query);\n\n        // Cache the database result\n        file_put_contents($filePath, serialize($dbResult));\n\n        return $dbResult;\n    }\n\n    private function queryDatabase($query) {\n        // Simulate database connection and query execution\n        // Replace with actual DB connection and query logic\n        $mysqli = new mysqli("localhost", "user", "password", "database");\n        if ($mysqli->connect_error) {\n            die("Connection failed: " . $mysqli->connect_error);\n        }\n\n        $result = $mysqli->query($query);\n        if ($result && $result->num_rows > 0) {\n            // Fetch all data\n            $data = [];\n            while ($row = $result->fetch_assoc()) {\n                $data[] = $row;\n            }\n            return $data;\n        }\n\n        return null;\n    }\n}\n\n// Usage\n$cache = new QueryCache('path/to/cache/directory');\n$queryResult = $cache->getCachedQueryResult("SELECT * FROM your_table");\nprint_r($queryResult);\n?>