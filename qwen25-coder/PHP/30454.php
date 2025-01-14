<?php\n\ninterface SystemAccessible {\n    public function performInternalOperation(SystemService $service);\n}\n\nclass SystemService {\n    public function executeRestrictedOperation(SystemAccessible $object) {\n        // Only classes that implement SystemAccessible can call this method\n        if (!$object instanceof SystemAccessible) {\n            throw new \Exception("Access Denied");\n        }\n        // Perform the system operation here\n    }\n}\n\nclass ObjectA implements SystemAccessible {\n    private $service;\n\n    public function __construct(SystemService $service) {\n        $this->service = $service;\n    }\n\n    public function performInternalOperation(SystemService $service) {\n        $service->executeRestrictedOperation($this);\n    }\n}\n\nclass ObjectB implements SystemAccessible {\n    private $service;\n\n    public function __construct(SystemService $service) {\n        $this->service = $service;\n    }\n\n    public function performInternalOperation(SystemService $service) {\n        $service->executeRestrictedOperation($this);\n    }\n\n    // Additional methods for ObjectB\n}\n\n// Usage\n$service = new SystemService();\n$objA = new ObjectA($service);\n$objB = new ObjectB($service);\n\ntry {\n    $objA->performInternalOperation($service); // Allowed\n    $objB->performInternalOperation($service); // Allowed\n    $service->executeRestrictedOperation(new \StdClass()); // Attempt to access from outside without proper interface - throws Exception\n} catch (\Exception $e) {\n    echo 'Error: ' . $e->getMessage();\n}