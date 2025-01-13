BEGIN\n  FOR cur_rec IN (SELECT OWNER, TABLE_NAME \n                  FROM ALL_TABLES \n                  WHERE OWNER = 'OWNINGUSER') LOOP\n    EXECUTE IMMEDIATE 'GRANT SELECT ON ' || cur_rec.OWNER || '.' || cur_rec.TABLE_NAME || ' TO ReceivingUser';\n  END LOOP;\nEND;