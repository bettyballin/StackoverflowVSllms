function table() {\n    global $rows;\n    ot();\n    for($x=0; $x<$rows; $x++) {  \n        table_row($x);\n    }\n    ct();\n}