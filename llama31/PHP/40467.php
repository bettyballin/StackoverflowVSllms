function appendParam(&$req, $name, $value) {\n    if (is_null($req) || is_null($name)) {\n        return;\n    }\n    if (!is_null($value)) {\n        $req[$name] = $value;\n    }\n}