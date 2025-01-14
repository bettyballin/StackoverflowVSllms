class Logger {\n    public static function log(string $message): void {\n        // Log the message to a file or monitoring system.\n    }\n}\n\nclass ErrorHandler {\n    public static function handle(Exception $exception): void {\n        Logger::log($exception->getMessage());\n        // Additional error handling steps.\n    }\n}