$startAttr = '<ATTR>';\n$endAttr = '</ATTR>';\n\nwhile ($item = current($data)) {\n    echo $startAttr, $item, $endAttr, "\n";\n    next($data);\n}