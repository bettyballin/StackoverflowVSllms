$attrStart = '<ATTR>';\n$attrEnd   = '</ATTR>' . "\n";\n\nwhile ($item = current($data)){\n    echo $attrStart, $item, $attrEnd;\n    next($data);\n}