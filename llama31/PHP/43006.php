function parse_template($template) {\n    $pattern = '/<!--if\(([^\)]+)\)-->(.*?)<!--endif-->/s';\n    return preg_replace_callback($pattern, 'evaluate_condition', $template);\n}\n\nfunction evaluate_condition($match) {\n    $condition = $match[1];\n    $content = $match[2];\n    if (eval("return $condition;")) {\n        return $content;\n    } else {\n        return '';\n    }\n}