$data = [\n    ['id' => 1, 'name' => 'John00', 'value' => 0.4],\n    ['id' => 2, 'name' => 'Ann01', 'value' => 0.001],\n    ['id' => 1, 'name' => 'John00', 'value' => 0.2],\n    ['id' => 3, 'name' => 'Ann', 'value' => 0.1],\n    ['id' => 2, 'name' => 'Ann01', 'value' => 0.01],\n    ['id' => 1, 'name' => 'John00', 'value' => 0.3],\n];\n\n$result = array_reduce($data, function ($carry, $item) {\n    if (!isset($carry[$item['id']])) {\n        $carry[$item['id']] = $item;\n    } else {\n        $carry[$item['id']]['value'] += $item['value'];\n    }\n    return $carry;\n}, []);\n\n$result = array_values($result);\n\nprint_r($result);