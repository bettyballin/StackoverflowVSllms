<?php\n$threadSafe = (bool)extension_loaded('zts');\nif ($threadSafe) {\n    echo "PHP is running in thread-safe mode.";\n} else {\n    echo "PHP is not running in thread-safe mode.";\n}