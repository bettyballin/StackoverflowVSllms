class Item {\n    private $contents = array('id' => 1);\n\n    public function getContents() {\n        return $this->contents;\n    }\n}\n\n$i = new Item();\n$id = $i->getContents()['id']; // This is valid\necho $id; // Output: 1