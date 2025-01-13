function get_instances_of_class($className) {\n    $instances = [];\n    foreach (get_defined_vars() as $var => $value) {\n        if (is_subclass_of($value, $className)) {\n            $instances[] = $value;\n        }\n    }\n    return $instances;\n}