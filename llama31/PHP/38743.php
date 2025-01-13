class Foo {\n    public $somethingelse;\n\n    function __construct() {\n        echo 'I am Foo';\n        $this->composition();\n    }\n\n    function composition() {\n        $this->somethingelse = new SomethingElse();\n    }\n}\n\nclass Bar extends Foo {\n    function __construct() {\n        parent::__construct(); // Call the parent constructor\n        echo 'I am Bar, my parent is Foo';\n    }\n}\n\nclass SomethingElse {\n    function __construct() {\n        echo 'I am some other class';\n    }\n\n    function test() {\n        echo 'I am a method in the SomethingElse class';\n    }\n}