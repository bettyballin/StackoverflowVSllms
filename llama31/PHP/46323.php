private $variables = array();\n\npublic function addVariable($key, $value) {\n    $this->variables[$key] = $value;\n}\n\npublic function iterateVariables() {\n    foreach ($this->variables as $key => $value) {\n        echo "$key => $value\n";\n    }\n}