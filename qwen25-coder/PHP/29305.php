class Base {\n\n    function __construct() {\n        echo '<p>get_class: '.get_class($this).'</p>';\n        echo '<p>__CLASS__: '.__CLASS__.'</p>';\n        echo '<p>get_called_class: '.get_called_class().'</p>';\n    }\n\n}\n\nclass Foo extends Base {\n\n}\n\n$test = new Foo();