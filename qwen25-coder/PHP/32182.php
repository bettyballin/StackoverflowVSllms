<?php\n$string = "This is a sample text that will be wrapped into three separate lines.";\n$wrappedString = wordwrap($string, 25, "<br>\n");\necho $wrappedString;\n?>