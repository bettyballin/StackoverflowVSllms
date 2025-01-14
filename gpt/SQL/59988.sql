SELECT \n    child.id, \n    child.name, \n    child.created_at, \n    parent.created_at AS parent_created_at\nFROM \n    your_table AS child\nLEFT JOIN \n    your_table AS parent\nON \n    child.parent_id = parent.id\nWHERE \n    child.parent_id > 0 OR child.parent_id IS NULL;