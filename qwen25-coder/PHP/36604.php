// In your UsersController or any other appropriate location\npublic function beforeValidate($options = []) {\n    $controllerNames = App::objects('Controller');\n\n    // Remove 'App' from each controller name if present\n    $controllers = array_map(function($controller) {\n        return substr($controller, 0, -10); // Remove 'Controller'\n    }, $controllerNames);\n\n    // Assuming you have a field named 'username' in your model\n    if (in_array($this->request->data['User']['username'], $controllers)) {\n        $this->Users->invalidate('username', 'This username is reserved.');\n        return false;\n    }\n\n    return true;\n}