-- Windows Authentication (default)\n-- This typically happens automatically or through connection strings in client applications\nSELECT * FROM [Adventure Works];\n\n-- SQL Server Authentication (not recommended due to security concerns)\nUSE [master]\nGO\nCREATE LOGIN [SSASUser] WITH PASSWORD=N'Password123!';\nUSE [YourAnalysisServicesDB]\nGO\nCREATE USER [SSASUser] FOR LOGIN [SSASUser];\nGRANT SELECT TO [SSASUser];