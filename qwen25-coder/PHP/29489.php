class clsUsagerEmailUserName {\n    private $nickName;\n    private $email;\n\n    function __construct($email, $nickName = null) {\n        $this->email = $email;\n        if ($nickName !== null) {\n            $this->nickName = $nickName;\n        }\n    }\n\n    // Other methods...\n}