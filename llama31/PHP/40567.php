$arrays = array(\n    'kanye' => array('Kanya', 'Janaye', 'Kayne', 'Kane', 'Kaye'),\n    'wst' => array('ST', 'St', 'st', 'EST', 'West')\n);\n\nforeach ($arrays as $key => $array) {\n    echo $key . ":\n";\n    print_r($array);\n    echo "\n";\n}