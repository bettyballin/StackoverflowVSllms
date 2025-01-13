// controllers/UserController.php\nclass UserController {\n    public function index() {\n        $users = UserModel::getAllUsers();\n        $view = new View('users/index');\n        $view->assign('users', $users);\n        $view->render();\n    }\n}\n\n// views/users/index.php\n<h1>Users</h1>\n<ul>\n    <?php foreach ($users as $user) : ?>\n        <li><?= $user->name ?></li>\n    <?php endforeach; ?>\n</ul>