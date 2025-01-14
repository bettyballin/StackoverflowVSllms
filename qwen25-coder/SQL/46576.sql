SELECT \n    name AS FunctionName,\n    type_desc AS FunctionType\nFROM \n    sys.objects\nWHERE \n    type IN ('FN', 'IF', 'TF', 'FS', 'FT')\nORDER BY \n    name;