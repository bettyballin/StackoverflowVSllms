interface Observer {\n    public function update(Entity $entity);\n}\n\nclass DataMapper implements Observer {\n    private $databaseConnection;\n\n    public function __construct($databaseConnection) {\n        $this->databaseConnection = $databaseConnection;\n    }\n\n    public function update(Entity $entity) {\n        // Logic to save entity state to the database\n        $stmt = $this->databaseConnection->prepare("UPDATE table SET column=:value WHERE id=:id");\n        $stmt->execute([\n            'value' => $entity->getValue(),\n            'id' => $entity->getId()\n        ]);\n    }\n\n    public function mapToObject($row) {\n        $entity = new Entity($row['id']);\n        $entity->setValue($row['column']);\n\n        // Register the mapper as an observer\n        $entity->attachObserver($this);\n\n        return $entity;\n    }\n}\n\nclass Entity {\n    private $observers = [];\n    private $value;\n    private $id;\n\n    public function __construct($id) {\n        $this->id = $id;\n    }\n\n    public function setValue($value) {\n        if ($this->value !== $value) {\n            $this->value = $value;\n            $this->notify();\n        }\n    }\n\n    public function getValue() {\n        return $this->value;\n    }\n\n    public function getId() {\n        return $this->id;\n    }\n\n    public function attachObserver(Observer $observer) {\n        $this->observers[] = $observer;\n    }\n\n    private function notify() {\n        foreach ($this->observers as $observer) {\n            $observer->update($this);\n        }\n    }\n}