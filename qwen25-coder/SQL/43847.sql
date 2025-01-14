-- Create a proxy login (if you have a service account)\nEXEC sp_addlogin 'ProxyUser', 'StrongPassword!'\nGO\n\n-- Grant db access to the proxy user in your target database\nUSE YourDatabaseName\nGO\nEXEC sp_grantdbaccess 'ProxyUser'\nGO\n\n-- Ensure ProxyUser has necessary permissions to target tables\nGRANT INSERT, UPDATE ON TargetTable TO ProxyUser\nGO