function appendParam(&$req, $name, $value) {\n    if ($req === null) {\n        return;\n    }\n    if ($name === null) {\n        return;\n    }\n    if ($value !== null) {\n        $req[$name] = $value;\n    }\n}