BEGIN\n  DBMS_SCHEDULER.set_attribute (\n    name      => 'MY_PROCEDURE_JOB',\n    attribute => 'max_run_duration',\n    value     => INTERVAL '5' MINUTE -- Set the desired timeout duration\n  );\nEND;\n/