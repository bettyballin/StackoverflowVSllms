function testParam($params) {\n    $fruit = $params['fruit'] ?? '';\n    $veg = $params['veg'] ?? 'pota';\n    $test = $params['test'] ?? 'default test';\n    echo '<br>$fruit = ' . $fruit;\n    echo '<br>$veg = ' . $veg;\n    echo '<br>Test = ' . $test;\n}\n\ntestParam(['fruit' => 'apple', 'test' => 'i am set']);