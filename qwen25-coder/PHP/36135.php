/**\n    * @throws InvalidArgumentException When the input is invalid.\n    */\n   function processInput($input) {\n       if (!is_string($input)) {\n           throw new InvalidArgumentException('Invalid type');\n       }\n       // processing logic...\n   }