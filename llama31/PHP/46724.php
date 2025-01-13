// In your controller\npublic $components = array(\n    'Auth' => array(\n        'authorize' => array('CustomAuthorize')\n    )\n);\n\n// In your CustomAuthorize.php file\nclass CustomAuthorize {\n\n    public function authorize($user, CakeRequest $request) {\n        if ($user && in_array($request->action, array('register', 'other_action'))) {\n            return false;\n        }\n        return true;\n    }\n}