-- To enable xp_cmdshell:\n  EXEC sp_configure 'show advanced options', 1;\n  RECONFIGURE;\n  EXEC sp_configure 'xp_cmdshell', 1;\n  RECONFIGURE;\n\n  -- To disable xp_cmdshell:\n  EXEC sp_configure 'xp_cmdshell', 0;\n  RECONFIGURE;