class DependencyContainer {\n    private $instances = [];\n    private $config;\n\n    public function __construct(array $config) {\n        $this->config = $config;\n    }\n\n    public function get($key) {\n        if (!isset($this->instances[$key])) {\n            $dependencies = isset($this->config[$key]['dependencies']) ? $this->resolveDependencies($this->config[$key]['dependencies']) : [];\n            $this->instances[$key] = new $this->config[$key]['class'](...$dependencies);\n        }\n        return $this->instances[$key];\n    }\n\n    private function resolveDependencies(array $dependencies) {\n        return array_map([$this, 'get'], $dependencies);\n    }\n}\n\n// Configuration of services/components\n$config = [\n    'logger' => ['class' => 'Logger'],\n    'userService' => ['class' => 'UserService', 'dependencies' => ['logger']]\n];\n\n$container = new DependencyContainer($config);\n\n$userService = $container->get('userService');