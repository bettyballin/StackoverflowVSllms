UPDATE performance_schema.setup_instruments SET ENABLED = 'YES', TIMED = 'YES'\n   WHERE NAME LIKE '%statement/sql%';\n   \n   UPDATE performance_schema.setup_consumers SET ENABLED = 'YES'\n   WHERE NAME LIKE '%events_statements_%';