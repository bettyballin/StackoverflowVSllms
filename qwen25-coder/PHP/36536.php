$User = new User();\n$valid = $User->ValidReg();\nif ($valid === false) {\n    // Handle invalid registration\n}