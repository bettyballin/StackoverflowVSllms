RESTORE DATABASE MyDatabase\n   FROM DISK = 'MyDatabase.bak'\n   WITH NORECOVERY, REPLACE\n\nRESTORE LOG MyDatabase\n   FROM DISK = 'MyDatabase.bak'\n   WITH RECOVERY