<?php\n\n$dirname = "images";\n$images = scandir($dirname);\n$ignore = Array(".", "..", "otherfiletoignore");\n\nforeach($images as $curimg){\n    if (!in_array($curimg, $ignore)) {\n        echo "<img src='images/$curimg' /><br />";\n        echo htmlspecialchars($curimg) . "<br />\n";\n    }\n} \n\n?>