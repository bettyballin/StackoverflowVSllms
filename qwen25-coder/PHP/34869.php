<?php\n\nrequire 'vendor/autoload.php';\n\nuse PhpConsole\Color;\nuse PhpConsole\Table;\n\n$data = [\n    ['fld_id', 'fld_name', 'fld_email'],\n    [1, 'A value', 'another value'],\n    [2, 'A value', ''],\n    [3, 'A value', 'another value']\n];\n\n$table = new Table();\n$table->setHeaders($data[0])\n      ->addRows(array_slice($data, 1))\n      ->display();\n\n?>