class DoDoDo {\n   public $poop;\n   public function __construct(){\n        $this->poop = new ArrayTest(); // Corrected line\n    }\n    public function foo() {\n        echo 'bar';\n    }\n}