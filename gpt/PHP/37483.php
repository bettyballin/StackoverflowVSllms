$content = '<div id="content"> \n\n\n<div id="contentleft">  <SCRIPT language=JavaScript>\n';\n$pattern = '/<div id="contentleft">/s';\n\nif (preg_match($pattern, $content, $matches)) {\n    echo "Match found: " . $matches[0];\n} else {\n    echo "No match found.";\n}