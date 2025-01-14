// composer.json\n{\n    "require": {\n        "symfony/security-core": "^5.0",\n        "symfony/security-http": "^5.0"\n    }\n}\n\n// Usage in PHP code\nuse Symfony\Component\Security\Core\Authentication\Token\Storage\TokenStorage;\nuse Symfony\Component\Security\Core\Authentication\AuthenticationManagerInterface;\nuse Symfony\Component\Security\Core\User\UserInterface;\n\nclass SimpleAuthenticator\n{\n    private $tokenStorage;\n    private $authenticationManager;\n\n    public function __construct(TokenStorage $tokenStorage, AuthenticationManagerInterface $authenticationManager)\n    {\n        $this->tokenStorage = $tokenStorage;\n        $this->authenticationManager = $authenticationManager;\n    }\n\n    public function login(UserInterface $user)\n    {\n        $token = $this->authenticationManager->authenticate(new UsernamePasswordToken($user, null, 'main', $user->getRoles()));\n        $this->tokenStorage->setToken($token);\n    }\n}\n\n// Implement your UserProvider and other configurations as needed.