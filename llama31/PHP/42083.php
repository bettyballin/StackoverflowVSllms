public function testglobalAction()\n{\n    $GLOBALS['a'] = 1;\n    function b()\n    {\n        echo $GLOBALS['a'] * 2;\n    }\n    b();\n}