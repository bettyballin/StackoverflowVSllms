if (!isset($_SESSION["account"]["user_account_id"])) {\n    throw new Exception("User account ID is not set in the session.");\n}\n\nif (!is_object($this->Model)) {\n    throw new Exception("Model is not an object.");\n}