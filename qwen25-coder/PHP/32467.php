<?php\n$today = new DateTime();\n$yesterday = $today->modify('-1 day');\necho $yesterday->format('F jS, Y');\n?>