class UserService {\n    protected $_userMapper;\n\n    public function __construct(UserMapper $userMapper) {\n        $this->_userMapper = $userMapper;\n    }\n\n    public function activateUser($userId) {\n        $user = new User();\n        $this->_userMapper->find($userId, $user);\n        $user->setStatus('active');\n        $this->_userMapper->save($user);\n    }\n}\n\n// Usage in a controller\n$userService = new UserService(new UserMapper());\n$userService->activateUser(1);