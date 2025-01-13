UPDATE my_table\nSET xml = \n  XMLQuery(\n    'copy $d := $xml \n     modify (\n       replace value of $d/a/b with 1,\n       replace value of $d/a/c with 2\n     ) \n     return $d'\n    PASSING xml AS "xml"\n    RETURNING CONTENT\n  )\nWHERE document_id = 123;