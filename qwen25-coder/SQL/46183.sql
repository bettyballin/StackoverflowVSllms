DECLARE @String NVARCHAR(255);\nSET @String = N'First Line' + CHAR(13) + CHAR(10) + 'Second Line';\nSELECT @String AS FormattedString;