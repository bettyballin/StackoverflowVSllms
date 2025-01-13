class Person {\n    public $id;\n    public $name;\n\n    public function __construct($id, $name) {\n        $this->id = $id;\n        $this->name = $name;\n    }\n\n    function getHash() {\n        return $this->id . $this->name;\n    }\n}\n\nclass PersonArray implements Iterator {\n    public $items = array();\n    public $itemsHash = array();\n    private $internalRegisteredHashList = array();\n    private $position = 0;\n\n    public function Find($pKey) {\n        if ($this->ContainsKey($pKey)) {\n            return $this->items[$this->internalRegisteredHashList[$pKey]];\n        }\n    }\n\n    public function Add($object) {\n        $hash = $object->getHash();\n        if ($hash) {\n            $this->internalRegisteredHashList[$hash] = count($this->items);\n            array_push($this->items, $object);\n            array_push($this->itemsHash, $hash);\n        }\n    }\n\n    public function insertAt($index, $object) {\n        $hash = $object->getHash();\n        if ($hash) {\n            array_splice($this->items, $index, 0, array($object));\n            array_splice($this->itemsHash, $index, 0, array($hash));\n            \n            // Update internal hash list indexes\n            $this->internalRegisteredHashList = array();\n            foreach ($this->items as $key => $item) {\n                $this->internalRegisteredHashList[$item->getHash()] = $key;\n            }\n        }\n    }\n\n    public function getItems() {\n        return $this->items;\n    }\n\n    function ContainsKey($pKey) {\n        return isset($this->internalRegisteredHashList[$pKey]);\n    }\n\n    function Count() {\n        return count($this->items);\n    }\n\n    function Item($pKey) {\n        return $this->items[$pKey];\n    }\n\n    // Iterator implementation\n    public function rewind() {\n        $this->position = 0;\n    }\n\n    public function current() {\n        return $this->items[$this->position];\n    }\n\n    public function key() {\n        return $this->position;\n    }\n\n    public function next() {\n        ++$this->position;\n    }\n\n    public function valid() {\n        return isset($this->items[$this->position]);\n    }\n}