class Bar extends Foo {\n    // Old-style constructor\n    public function Bar() {\n        // Calling parent constructor\n        parent::Foo(); // Old-style call\n    }\n    \n    // New-style constructor\n    public function __construct() {\n        // Calling parent constructor\n        parent::__construct(); // Preferred new-style call\n    }\n}