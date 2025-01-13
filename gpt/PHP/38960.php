public $form = array(\n    array(\n        'field' => 'email',\n        'params' => array(\n            array(\n                'rule' => 'email',\n                'on' => 'create',\n                'required' => true,\n                'error' => 'The email is invalid!'\n            ),\n            array(\n                'rule' => 'email',\n                'on' => 'update',\n                'required' => false,\n                'error' => 'The email is invalid!'\n            )\n        )\n    )\n);\n\npublic function onlyNeeded($action) {\n    $form = $this->form;\n\n    foreach ($form as $formIndex => &$formelement) {\n        $paramsgroup = &$formelement['params'];\n        foreach ($paramsgroup as $paramIndex => $params) {\n            if ($params['on'] != $action) {\n                unset($paramsgroup[$paramIndex]);\n            }\n        }\n        // Re-index params array to keep it clean\n        $paramsgroup = array_values($paramsgroup);\n    }\n    return $form;\n}\n\n// Example usage:\n$action = 'create';\n$result = $this->onlyNeeded($action);\nprint_r($result);