<?php\n\nclass FanStruct{\n    public $date;\n    public $userid;\n\n    function __construct($date, $id){\n        $this->date = $date;\n        $this->userid = $id;\n    }\n\n    public function __toString()\n    {\n      return $this->date . $this->userid;\n    }\n}\n\n$test = array(\n  new FanStruct( 'today', 1 )\n  ,new FanStruct( 'today', 1 )\n  ,new FanStruct( 'tomorrow', 1 )\n);\n\nprint_r( array_unique( $test ) );\n\n?>