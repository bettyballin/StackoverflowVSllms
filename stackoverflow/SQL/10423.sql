SELECT \n    'DROP INDEX ' + ix.name + ' ON ' + OBJECT_NAME(ID)\nFROM \n    sysindexes ix\nWHERE   \n    ix.Name IS NOT null