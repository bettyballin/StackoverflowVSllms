enum UserType: string {\n    case ADMIN = 'admin';\n    case USER = 'user';\n    case GUEST = 'guest';\n}\n\nclass Foo {\n    public UserType $userType;\n\n    public function __construct(UserType $type) {\n        $this->userType = $type;\n    }\n}\n\n$foo = new Foo(UserType::GUEST);\necho $foo->userType->value; // Displays "guest"