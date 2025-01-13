<?php\nclass foo {\n  protected $bar;\n\n  public function __construct()\n  {\n    $this->bar = array();\n  }\n\n  public function &getBar()\n  {\n    return $this->bar;\n  }\n}\n\nclass foo2 {\n\n  var $barReference;\n  var $fooInstance;\n\n  public function __construct()\n  {\n    $this->fooInstance = new foo();\n    $this->barReference = &$this->fooInstance->getBar();\n  }\n}\n$testObj = new foo2();\n$testObj->barReference[] = 'apple';\n$testObj->barReference[] = 'peanut';\n?>\n<h1>Reference</h1>\n<pre><?php print_r($testObj->barReference) ?></pre>\n<h1>Object</h1>\n<pre><?php print_r($testObj->fooInstance) ?></pre>