class clsUsagerEmailUserName {\n    function __construct($email, $nickName = null) {\n        $this->email = $email;\n        if ($nickName !== null) {\n            $this->nickName = $nickName;\n        }\n    }\n}