$result = array();\nforeach ($nodes as $node) {\n    $result[$node['Category']['id']] = $node['Category']['name'];\n}