UPDATE YourTable\nSET YourColumn = REPLACE(YourColumn COLLATE Latin1_General_BIN, 'searchString', 'replaceString')\nWHERE YourColumn COLLATE Latin1_General_BIN LIKE '%searchString%';