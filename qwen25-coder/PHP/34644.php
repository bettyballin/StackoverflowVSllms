class CustomFilterIterator extends FilterIterator {\n    private $processor;\n\n    public function __construct(Iterator $iterator, ItemProcessor $processor) {\n        parent::__construct($iterator);\n        $this->processor = $processor;\n    }\n\n    public function accept() {\n        return $this->processor->shouldProcess($current = parent::current());\n    }\n}\n\n// Usage\n$items1 = new ArrayObject($array1);\n$filteredFooItems = new CustomFilterIterator(new ArrayIterator($items1), $fooProcessor);\nforeach ($filteredFooItems as $item) {\n    $fooProcessor->process($item);\n}