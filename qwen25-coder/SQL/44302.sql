-- Check if TCP/IP networking is enabled:\n   sp_configure 'show advanced options', 1;\n   GO\n   RECONFIGURE;\n   GO\n   sp_configure 'remote connect', 1;\n   GO\n   RECONFIGURE;\n   GO