class Animal {\n    var $name;\n    function __construct($name) {\n        $this->name = $name;\n    }\n}\n\nclass Dog extends Animal {\n    function speak() {\n        return "Woof, woof!";\n    }\n}\n\nclass Cat extends Animal {\n    function speak() {\n        return "Meow...";\n    }\n}\n\n$animals = array(new Dog('Skip'), new Cat('Snowball'));\n\nforeach($animals as $animal) {\n    print $animal->name . " says: " . $animal->speak() . '<br>';\n}