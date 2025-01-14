class Account {\n    /* Class variables */\n\n    public function login(array $post, array $session, array $cookies) {\n        if (isset($post['username']) && isset($post['password']))\n            return $this->_formLogin($post);\n        else if (isset($session['accountId']))\n            return $this->_sessionLogin($session['accountId']);\n        else if (isset($cookies['username']) && isset($cookies['password']))\n            return $this->_cookieLogin($cookies['username'], $cookies['password']);\n        else return false;\n    }\n\n    private function _formLogin(array $post) {\n        // perform login actions using $post data\n    }\n\n    private function _sessionLogin($accountId) {\n        // perform session-based login actions\n    }\n\n    private function _cookieLogin($username, $password) {\n        // perform cookie-based login actions\n    }\n}\n\n// Usage example:\n$user = new Account();\nif ($user->login($_POST, $_SESSION, $_COOKIE)) {\n    // Do this stuff when logged in\n}