if (is_array($value) || $value instanceof ArrayAccess) {\n    echo "The variable is an array or an object that implements ArrayAccess";\n} else {\n    echo "The variable is not an array or an object that implements ArrayAccess";\n}