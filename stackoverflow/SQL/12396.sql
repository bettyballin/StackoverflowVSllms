alter session set tracefile_identifier = 'something-unique'\nalter session set sql_trace = true;\nalter session set events '10046 trace name context forever, level 8';\n\nselect 'right-before-my-sp' from dual;\nexec your_stored_procedure\n\nalter session set sql_trace = false;