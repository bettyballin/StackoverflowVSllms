class Console {\n    private $enabled = false;\n    private $logFile = 'console.log';\n\n    public function __construct($enabled = false) {\n        $this->enabled = $enabled;\n    }\n\n    public function log($message) {\n        if ($this->enabled) {\n            file_put_contents($this->logFile, date('Y-m-d H:i:s') . ' - ' . $message . PHP_EOL, FILE_APPEND);\n        }\n    }\n\n    public function error($message) {\n        if ($this->enabled) {\n            file_put_contents($this->logFile, date('Y-m-d H:i:s') . ' - ERROR - ' . $message . PHP_EOL, FILE_APPEND);\n        }\n    }\n\n    public function enable() {\n        $this->enabled = true;\n    }\n\n    public function disable() {\n        $this->enabled = false;\n    }\n}