class Search {\n    private static $instance = null;\n\n    // Private constructor to prevent instantiation\n    private function __construct() {}\n\n    public static function getInstance() {\n        if (self::$instance === null) {\n            self::$instance = new self();\n        }\n        return self::$instance;\n    }\n\n    public function performSearch($query) {\n        // Perform the search logic here\n        return "Searching for: $query";\n    }\n}\n\n// Usage\n$search1 = Search::getInstance();\necho $search1->performSearch("PHP Singleton");\n\n$search2 = Search::getInstance();\necho $search2->performSearch("Another Query");