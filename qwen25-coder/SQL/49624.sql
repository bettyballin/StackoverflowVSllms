-- Enable xp_cmdshell if required\nEXEC sp_configure 'show advanced options', 1;\nRECONFIGURE;\nEXEC sp_configure 'xp_cmdshell', 1;\nRECONFIGURE;\n\n-- Run PowerShell script\nDECLARE @cmd varchar(256)\nSET @cmd = 'powershell -ExecutionPolicy Bypass -File "C:\path\to\UnzipFiles.ps1"'\nEXEC xp_cmdshell @cmd\n\n-- Perform bulk insert after unzipping\nBULK INSERT MyTable\nFROM 'C:\path\to\extracted\files\datafile.csv'\nWITH (\n    FIELDTERMINATOR = ',',\n    ROWTERMINATOR = '\n'\n);\n\n-- Reset settings if necessary\nEXEC sp_configure 'xp_cmdshell', 0;\nRECONFIGURE;