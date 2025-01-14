// Define a simple class\nclass User {\n    public $name;\n    public $age;\n\n    public function __construct($name, $age) {\n        $this->name = $name;\n        $this->age = $age;\n    }\n}\n\n// Create an array to hold objects\n$users = [];\n\n// Create instances of the User class and add them to the array\n$user1 = new User("Alice", 30);\n$user2 = new User("Bob", 25);\n\n$users[] = $user1;\n$users[] = $user2;\n\n// Accessing the objects in the array\nforeach ($users as $user) {\n    echo "Name: " . $user->name . ", Age: " . $user->age . "\n";\n}