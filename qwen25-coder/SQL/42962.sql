-- Example simplified view for each level if needed.\nCREATE VIEW ViewLevel1 AS\nSELECT * \nFROM ReportingHierarchy WHERE LevelID = 1;\n\nCREATE VIEW ViewTopLevel AS\nSELECT * \nFROM ReportingHierarchy WHERE LevelID = 0;