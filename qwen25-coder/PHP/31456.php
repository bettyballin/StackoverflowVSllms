<?php\n\n// The class whose method returns an array of library_Label objects\nclass library_Label\n{\n  public $id = null;\n  public $name = null;\n\n  public function getChildren()\n  {\n    // Ensure $children is always initialized as an array\n    $children = []; // Initialize as an empty array\n\n    // You can add logic here to populate the $children array if needed\n\n    return $children; // Return the array\n  }\n}\n\n// main code\n$columns = new library_Label(1);\nforeach ($columns->getChildren() as $label) echo $label->name;\n\n?>