$vars = array('var1', 'var2', 'var3');\nforeach ($vars as $var) {\n    unset($$var);\n}