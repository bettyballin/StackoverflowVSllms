class Organization {\n    private $orgId;\n    private $orgName;\n\n    public function isValid(): bool {\n        return !empty($this->orgName);\n    }\n\n    public function getOrgType(): string {\n        // Simple example, in a real-world scenario, this might involve more logic\n        if (strpos($this->orgName, 'Non-Profit') !== false) {\n            return 'Non-Profit';\n        }\n        return 'Commercial';\n    }\n\n    // getters and setters\n}