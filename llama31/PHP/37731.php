$string = "<br>&nbsp; Your text here &nbsp;<br>";\n\n// Define the pattern of tags to remove\n$pattern = '/^(<br>|&nbsp;)+|(<br>|&nbsp;)+$/i';\n\n// Use preg_replace to remove the tags\n$cleanString = preg_replace($pattern, '', $string);\n\necho $cleanString;