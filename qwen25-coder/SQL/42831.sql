USE master;\nGO\nALTER DATABASE YourDatabaseName SET EMERGENCY;\nGO\nRESTORE DATABASE YourDatabaseName WITH RECOVERY, ABORT;\nGO