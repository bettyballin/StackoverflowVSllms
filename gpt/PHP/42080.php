<?php\nclass HomeController {\n    public function index() {\n        $user = new User();\n        $userData = $user->getUser(1);\n        include_once __DIR__ . '/../views/home.php';\n    }\n}