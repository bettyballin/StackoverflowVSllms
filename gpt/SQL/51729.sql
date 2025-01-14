-- First, drop the role if it exists\nDECLARE\n  role_count INTEGER;\nBEGIN\n  SELECT COUNT(*) INTO role_count FROM dba_roles WHERE role = 'ROLE_NAME';\n  IF role_count > 0 THEN\n    EXECUTE IMMEDIATE 'DROP ROLE ROLE_NAME';\n  END IF;\nEND;\n/\n\n-- Then, create the role\nCREATE ROLE ROLE_NAME;\n\n-- Grant privileges to the role\nGRANT SELECT ON SCM1_VIEW_OBJECT_VW TO ROLE_NAME;