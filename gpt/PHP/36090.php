class myclass {\n    public static function factory($id) {\n        // Add logging to verify the method is called\n        error_log("Factory method called with id: $id");\n\n        // Your factory logic here\n        return new self();\n    }\n}