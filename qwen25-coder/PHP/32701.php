$type = 'condition_a'; // this comes from some input or context\n\n// predefined template parts or logic for each condition\n$templates = [\n    'condition_a' => '<div>Template for A</div>',\n    'condition_b' => '<div>Template for B</div>',\n];\n\nif (isset($templates[$type])) {\n    echo $templates[$type];\n}