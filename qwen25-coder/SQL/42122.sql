-- To check the current Auto_Close setting for a specific database:\nSELECT name, is_auto_close_on \nFROM sys.databases \nWHERE name = 'YourDatabaseName';