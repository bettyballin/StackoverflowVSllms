public function onlyNeeded($action) {\n    $form = $this->form;\n\n    foreach ($form as &$formelement) {  // Use reference to modify the original array\n        $field = $formelement['field'];\n        $paramsgroup = &$formelement['params'];  // Reference to modify the parameters\n\n        // Filter params based on the action\n        $filteredParams = array_filter($paramsgroup, function($param) use ($action) {\n            return $param['on'] === $action;\n        });\n\n        // Assign filtered parameters back to the form element\n        $formelement['params'] = array_values($filteredParams);  // Re-index array\n\n    }\n    unset($formelement);  // Destroy reference to avoid side effects\n\n    return $form;\n}