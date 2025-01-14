<?php\nfunction convertSingleQuotesToDouble($html) {\n    // Use regular expression to match HTML tag attributes with single quotes\n    $pattern = "/(<[a-zA-Z0-9]+[^>]*=[^'\"]*')([^']*')([^>]*)>/";\n    $replacement = function ($matches) {\n        // Replace single quotes with double quotes in the matched segments\n        return str_replace("'", "\"", $matches[0]);\n    };\n    return preg_replace_callback($pattern, $replacement, $html);\n}\n\n$input = "<TEXTFORMAT LEADING='2'><P ALIGN='LEFT'><FONT FACE='Verdana' style=\"font-size:10' COLOR='#0B333C'>My name's Mark</FONT></P></TEXTFORMAT>";\n$output = convertSingleQuotesToDouble($input);\n\necho htmlspecialchars($output);\n?>