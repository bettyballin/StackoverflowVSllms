class Foo {\n    const USER_TYPE_ADMIN = 'admin';\n    const USER_TYPE_USER = 'user';\n    const USER_TYPE_GUEST = 'guest';\n\n    public $userType = self::USER_TYPE_ADMIN;\n\n    public function __construct($type) {\n        $this->userType = $type;\n    }\n}\n\n$foo = new Foo(Foo::USER_TYPE_GUEST);\necho $foo->userType;\n// Displays "guest"