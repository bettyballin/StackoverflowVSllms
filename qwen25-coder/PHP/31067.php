class ScpCommand extends Command {\n    public function __construct() {\n        parent::__construct('scp');\n        \n        // Set default options and arguments specific to scp\n        $this->addOption('-o', 'StrictHostKeyChecking=no'); // Example option\n        // Add other necessary default options here\n    }\n\n    // Additional methods specific to ScpCommand, if any\n}\n\n// Usage example:\n$scp = new ScpCommand();\n$scp->addArgument('/local/file');\n$scp->addArgument('user@remote:/remote/path');\necho $scp->getCommandString(); // Outputs: scp -o StrictHostKeyChecking=no /local/file user@remote:/remote/path