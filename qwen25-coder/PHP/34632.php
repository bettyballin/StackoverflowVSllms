preg_match('/<div id="content">\s*<div id="contentleft">/s', $html, $matches);\n\necho $matches[0];