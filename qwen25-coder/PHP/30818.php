function checkPasswords($data) {\n    // Directly compare the 'password' field with the second password field ('confirm_password')\n    if ($data['password'] === $this->data['User']['confirm_password']) {\n        return true;\n    } else {\n        return false;\n    }\n}