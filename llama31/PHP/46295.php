use Respect\Validation\Validator as v;\n\n$validator = v::create()->notEmpty()->email();\nif ($validator->validate('example@example.com')) {\n    // valid\n}