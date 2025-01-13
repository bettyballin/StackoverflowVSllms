interface OutputFormat {\n    public function export($data);\n}\n\nclass XmlOutputFormat implements OutputFormat {\n    private $dom;\n\n    public function __construct() {\n        $this->dom = new DOMDocument();\n    }\n\n    public function export($data) {\n        // Use DOM to create the XML structure\n        $root = $this->dom->createElement('root');\n        $this->dom->appendChild($root);\n        // ...\n        return $this->dom->saveXML();\n    }\n}\n\nclass CsvOutputFormat implements OutputFormat {\n    public function export($data) {\n        // Use fputcsv to create the CSV output\n        $fp = fopen('php://memory', 'w');\n        fputcsv($fp, $data);\n        rewind($fp);\n        return stream_get_contents($fp);\n    }\n}