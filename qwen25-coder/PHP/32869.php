// In any controller action\nfunction someAction()\n{\n    $userId = $this->Session->read('User.UserId');\n\n    if ($userId) {\n        // Use the user ID\n    } else {\n        // Handle no user ID in session\n    }\n}