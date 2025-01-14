-- Step 1: Enable xp_cmdshell if you are sure you need it.\nEXEC sp_configure 'show advanced options', 1;\nRECONFIGURE;\nGO\nEXEC sp_configure 'xp_cmdshell', 1;\nRECONFIGURE;\nGO\n\n-- Step 2: Use xp_cmdshell to get the environment variable value.\nDECLARE @envValue VARCHAR(100)\nCREATE TABLE #EnvironmentVariable (StringValue VARCHAR(100) NULL)\n\nINSERT INTO #EnvironmentVariable \n    EXEC master.dbo.xp_cmdshell 'echo %YOUR_ENV_VARIABLE%'\n\nSELECT TOP 1 @envValue = StringValue\nFROM #EnvironmentVariable\nWHERE StringValue IS NOT NULL;\n\nSELECT @envValue AS EnvironmentVariable;\n\n-- Cleanup: Disable xp_cmdshell again for security purposes.\nEXEC sp_configure 'xp_cmdshell', 0;\nRECONFIGURE;\nGO\n\nDROP TABLE #EnvironmentVariable;