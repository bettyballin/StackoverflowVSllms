function getConstant($matches) \n{\n    return constant($matches[1]);\n}\n$final=preg_replace_callback(\n           '/\{CONSTANT_(.*?)\}/',\n           "getConstant",\n           $final);