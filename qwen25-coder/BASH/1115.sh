# Add Oracle Instant Client to PATH (example for cmd prompt)\nset PATH=C:\oracle\instantclient_10_2;%PATH%\n\n# Check Oracle client version\nsqlplus -v\n\n# Test ODBC connection using isql (part of Instant Client ODBC package)\nisql mydsn user password