<?php\nfunction hasNumber($string) {\n    return preg_match('/\d/', $string) === 1;\n}\n\n// Test cases\nvar_dump(hasNumber("abc")); // false\nvar_dump(hasNumber("!./#()")); // false\nvar_dump(hasNumber("!./#()abc")); // false\nvar_dump(hasNumber("123")); // true\nvar_dump(hasNumber("abc123")); // true\nvar_dump(hasNumber("!./#()123")); // true\nvar_dump(hasNumber("abc !./#() 123")); // true\n?>