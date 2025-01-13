interface Logger {\n    public function log($message);\n}\n\nclass FileLogger implements Logger {\n    public function log($message) {\n        // log to file\n    }\n}\n\nclass DatabaseLogger implements Logger {\n    public function log($message) {\n        // log to database\n    }\n}