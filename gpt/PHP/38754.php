class BookShelf implements ArrayAccess, Countable, SeekableIterator {\n    protected $_books = array("Book1", "Book2", "Book3");\n    protected $_magazines = array("Magazine1", "Magazine2");\n    protected $_position = 0;\n    protected $_combined = array();\n\n    public function __construct() {\n        $this->_combined = array_merge($this->_books, $this->_magazines);\n    }\n\n    // ArrayAccess methods\n    public function offsetExists($offset) {\n        return isset($this->_combined[$offset]);\n    }\n\n    public function offsetGet($offset) {\n        return $this->_combined[$offset];\n    }\n\n    public function offsetSet($offset, $value) {\n        if (is_null($offset)) {\n            $this->_combined[] = $value;\n        } else {\n            $this->_combined[$offset] = $value;\n        }\n    }\n\n    public function offsetUnset($offset) {\n        unset($this->_combined[$offset]);\n    }\n\n    // Countable method\n    public function count() {\n        return count($this->_combined);\n    }\n\n    // SeekableIterator methods\n    public function seek($position) {\n        if (!isset($this->_combined[$position])) {\n            throw new OutOfBoundsException("Invalid seek position ($position)");\n        }\n        $this->_position = $position;\n    }\n\n    public function current() {\n        return $this->_combined[$this->_position];\n    }\n\n    public function key() {\n        return $this->_position;\n    }\n\n    public function next() {\n        ++$this->_position;\n    }\n\n    public function rewind() {\n        $this->_position = 0;\n    }\n\n    public function valid() {\n        return isset($this->_combined[$this->_position]);\n    }\n}\n\n$shelf = new BookShelf();\n\n// Loops through both arrays, first books (if any) and then magazines (if any)\nforeach ($shelf as $item) {\n    echo $item . "\n";\n}