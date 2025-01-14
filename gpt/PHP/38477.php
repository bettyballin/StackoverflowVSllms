class user {\n    var $password;\n    var $db;\n    var $user_id;\n\n    function __construct($id) {\n        global $DB;\n        $this->db = new db($DB['host'], $DB['user'], $DB['pass'], $DB['database']);\n        $this->user_id = $id;\n        $u_result = $this->db->run("SELECT * FROM users WHERE use_id = " . $this->db->escape($this->user_id));\n\n        if ($u_result) {\n            $this->password = trim($u_result[0]['password']);\n        } else {\n            // Handle the error, e.g., user not found\n        }\n    }\n\n    function match_password($password) {\n        return password_verify($password, $this->password);\n    }\n}\n\n// Storing a hashed password example\n$hashed_password = password_hash($_POST['pass'], PASSWORD_BCRYPT);