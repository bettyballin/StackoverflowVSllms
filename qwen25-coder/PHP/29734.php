<?php\n// Store a variable in the cache\napcu_store('my_key', 'value');\n\n// Fetch the variable from the cache\n$value = apcu_fetch('my_key');\necho $value;  // Outputs: value\n?>