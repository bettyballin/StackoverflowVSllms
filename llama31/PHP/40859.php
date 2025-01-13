class Logger {\n    private $writer;\n\n    public function __construct(Writer $writer) {\n        $this->writer = $writer;\n    }\n\n    public function log($message) {\n        $this->writer->write($message);\n    }\n}\n\ninterface Writer {\n    public function write($message);\n}\n\nclass FileWriter implements Writer {\n    public function write($message) {\n        // write to file\n    }\n}