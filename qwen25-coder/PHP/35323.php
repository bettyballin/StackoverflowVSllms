<?php\n  $whatever = true;\n\n  if ($whatever == true) {\n    echo "file2.php has been included<br />";\n    return; // This stops only file2.php from further execution\n  }\n\n  // Additional code here, this will not be executed if the condition is true.\n?>