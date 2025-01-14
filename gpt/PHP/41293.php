class Event implements EventInterface {\n    protected $eventType;\n\n    public function __construct($eventType) {\n        $this->eventType = $eventType;\n    }\n\n    public function getEventType() {\n        return $this->eventType;\n    }\n}\n\nclass Person implements PersonInterface {\n    protected $details;\n\n    public function __construct($details) {\n        $this->details = $details;\n    }\n\n    public function getPersonDetails() {\n        return $this->details;\n    }\n}