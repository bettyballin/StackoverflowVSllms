RMAN> RECOVER DATABASE UNTIL TIME 'SYSDATE-1' USING BACKUP CONTROLFILE;\n   -- If complete recovery is required and all logs are available:\n   RMAN> RECOVER DATABASE USING BACKUP CONTROLFILE;