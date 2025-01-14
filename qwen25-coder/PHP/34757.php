use Psr\Log\LoggerInterface;\n\nclass YourClass\n{\n    private $logger;\n\n    public function __construct(LoggerInterface $logger)\n    {\n        $this->logger = $logger;\n    }\n\n    public function yourMethod()\n    {\n        if ($this->logger instanceof \Monolog\Logger) {\n            // Check if the logger is enabled for debug level\n            if ($this->logger->isHandling(\Monolog\Logger::DEBUG)) {\n                $this->logMessage('Expensive operation return value: '.expensiveFunction(), 'debug');\n            }\n        } else {\n            $this->logMessage('Logger not an instance of Monolog\\Logger', 'warning');\n        }\n    }\n\n    private function logMessage($message, $level)\n    {\n        $this->logger->log(\Monolog\Logger::{$level}, $message);\n    }\n}