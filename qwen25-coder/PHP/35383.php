class TrackableArray {\n    private $data;\n    private $originalData;\n    private $isModified = false;\n\n    public function __construct(array $initialData = []) {\n        $this->data = $this->originalData = $initialData;\n    }\n\n    // Intercept array set operations\n    public function offsetSet($offset, $value) {\n        if (is_null($offset)) {\n            $this->data[] = $value;\n        } else {\n            $this->data[$offset] = $value;\n        }\n        $this->markAsModified();\n    }\n\n    // Intercept array get operations\n    public function offsetGet($offset) {\n        return $this->data[$offset];\n    }\n\n    // Check for key existence\n    public function offsetExists($offset) {\n        return isset($this->data[$offset]);\n    }\n\n    // Intercept unset operations\n    public function offsetUnset($offset) {\n        unset($this->data[$offset]);\n        $this->markAsModified();\n    }\n\n    // Count elements in an array\n    public function count() {\n        return count($this->data);\n    }\n\n    // Implement IteratorAggregate to allow foreach over TrackableArray objects\n    public function getIterator(): ArrayIterator {\n        return new ArrayIterator($this->data);\n    }\n\n    // Mark the object as modified\n    private function markAsModified() {\n        $this->isModified = true;\n    }\n\n    // Check if the array was modified\n    public function isModified(): bool {\n        return $this->isModified;\n    }\n\n    // Get the list of changes made\n    public function getChanges(): array {\n        $diff = array_diff_assoc($this->data, $this->originalData);\n        $removed = array_diff_key($this->originalData, $this->data);\n\n        return [\n            'updated' => $diff,\n            'added' => array_values(array_diff_key($this->data, $this->originalData)),\n            'removed' => array_keys($removed)\n        ];\n    }\n}\n\nclass Storage {\n    public $object;\n\n    public function __construct() {\n        // Example data\n        if (!isset($_SESSION['storage_data'])) {\n            $_SESSION['storage_data'] = ['a', 'b'];\n        }\n        $this->object = new TrackableArray($_SESSION['storage_data']);\n    }\n\n    public function saveChanges() {\n        if ($this->object->isModified()) {\n            $changes = $this->object->getChanges();\n            // Apply changes to the session or persistent storage\n            $_SESSION['storage_data'] = array_merge(\n                array_diff_key($this->object->originalData, array_flip($changes['removed'])),\n                $this->object->data\n            );\n\n            echo "Changes saved:", json_encode($changes);\n        }\n    }\n\n    public function __destruct() {\n        $this->saveChanges();\n    }\n}\n\n// Example usage\nsession_start();\n\n$storage = new Storage();\n$storage->object[] = 'c'; // Modify the trackable array\n\nforeach ($storage->object as $item) {\n    echo $item, PHP_EOL;\n}