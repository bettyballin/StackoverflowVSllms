<?\nfunction somefunc($stuff)\n{\n    $output = "<b>{$stuff}</b>";\n    return $output;\n}\n$somefunc='somefunc';\necho "foo {$somefunc("bar")} baz";\n?>