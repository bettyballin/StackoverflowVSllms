class ModuleTriggerManager {\n    private $handlers = [];\n\n    // Register a new handler for a specific trigger\n    public function register($trigger_name, callable $callback) {\n        if (!isset($this->handlers[$trigger_name])) {\n            $this->handlers[$trigger_name] = [];\n        }\n        $this->handlers[$trigger_name][] = $callback;\n    }\n\n    // Trigger all registered handlers for a specific trigger\n    public function trigger($trigger_name, $data = false) {\n        if (isset($this->handlers[$trigger_name])) {\n            foreach ($this->handlers[$trigger_name] as $handler) {\n                call_user_func($handler, $data);\n            }\n            return true;\n        }\n        return false;\n    }\n}\n\n// Usage\n$triggerManager = new ModuleTriggerManager();\n\n// Register a handler for a specific trigger\n$triggerManager->register('security', function($data) {\n    // Security checks here...\n});\n\n// Trigger the event\n$triggerManager->trigger('security', ['user_id' => 123]);