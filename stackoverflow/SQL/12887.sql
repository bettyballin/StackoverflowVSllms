SELECT OBJECT_DEFINITION(object_id), 'drop procedure [' + name + ']'\nFROM   sys.procedures\nWHERE modify_date >= @date