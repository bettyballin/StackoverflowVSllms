SELECT OWNER, OBJECT_NAME, OBJECT_TYPE, STATUS\nFROM ALL_OBJECTS\nWHERE OBJECT_TYPE = 'PACKAGE' AND STATUS = 'INVALID';