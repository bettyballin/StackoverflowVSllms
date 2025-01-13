class DB {\n    private $registeredQueries = array(\n        'USER_CHECKLOGIN' => "SELECT uid FROM Users WHERE email=? AND pw=?",\n    );\n\n    public function query($queryId, $params) {\n        if (!isset($this->registeredQueries[$queryId])) {\n            throw new Exception("Invalid query ID");\n        }\n        $query = $this->registeredQueries[$queryId];\n        // ...\n    }\n}