<?php\nrequire 'vendor/autoload.php';\n\nuse Darylknight\CliTable\Table;\nuse Darylknight\CliTable\Row;\n\n$data = [\n    ['fld_id' => 1, 'fld_name' => 'A value', 'fld_email' => 'another value'],\n    ['fld_id' => 2, 'fld_name' => 'A value', 'fld_email' => ''],\n    ['fld_id' => 3, 'fld_name' => 'A value', 'fld_email' => 'another value'],\n];\n\n$table = new Table();\n$table->setHeaders(['fld_id', 'fld_name', 'fld_email']);\n\nforeach ($data as $row) {\n    $table->addRow(new Row($row));\n}\n\necho $table->getTable();\n?>