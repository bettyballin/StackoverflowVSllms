$vars = array("abc", "!./#()", "!./#()abc", "123", "abc123", "!./#()123", "abc !./#() 123");\n\nforeach ($vars as $var) {\n    echo $var . ": " . (hasNumber($var) ? "true" : "false") . "\n";\n}