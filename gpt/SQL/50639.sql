SELECT UserID, Service, COUNT(*) AS TimesAccessed\nFROM YourTableName\nGROUP BY UserID, Service\nORDER BY UserID, Service;