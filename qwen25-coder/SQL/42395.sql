-- To enable TCP/IP for SQL Server, ensure it's enabled under SQL Server Network Configuration in SQL Server Configuration Manager.\n-- If needed, use the following SP to check current connection settings:\nEXEC sp_configure 'remote access';\nGO\n\n-- Restarting SQL Service after configuration changes\nUSE master;\nGO\nRECONFIGURE WITH OVERRIDE;\nGO