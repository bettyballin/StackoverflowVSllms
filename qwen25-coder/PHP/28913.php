$string = "Your text here<br> &nbsp;";\n$trimmedString = preg_replace('/<br>\s*$/', '', $string);\necho $trimmedString;