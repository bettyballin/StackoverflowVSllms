<?php\n$tidy = new Tidy();\n$tidy->parseString('<html><body>Hello World!</body></html>');\necho $tidy->cleanRepair();\n?>