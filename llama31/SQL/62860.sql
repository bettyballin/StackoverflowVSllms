-- Create a new audit policy\nCREATE AUDIT POLICY my_audit_policy\n  ACTIONS SELECT, INSERT, UPDATE, DELETE\n  ON my_schema.my_table;\n\n-- Enable unified auditing\nALTER SYSTEM SET audit_trail='DB' SCOPE=SPFILE;\n\n-- Configure asynchronous auditing\nALTER SYSTEM SET audit_commit_delay=10000 SCOPE=SPFILE;