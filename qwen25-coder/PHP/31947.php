<?php\n\nclass SimpleConsole {\n    private $enabled = false;\n\n    public function enable() {\n        $this->enabled = true;\n    }\n\n    public function disable() {\n        $this->enabled = false;\n    }\n\n    public function log($message) {\n        if ($this->enabled) {\n            echo "<script>console.log('" . htmlspecialchars(json_encode($message)) . "');</script>";\n        }\n    }\n}\n\n// Usage\n$console = new SimpleConsole();\n$console->enable(); // Turn on console\n\n$console->log("This is a log message.");\n$console->log(["key" => "value", "number" => 42]); // Logs arrays as well\n\n// $console->disable(); // Uncomment to turn off console\n?>