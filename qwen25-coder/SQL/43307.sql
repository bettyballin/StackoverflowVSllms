ALTER SESSION SET EVENTS '10046 trace name context forever, level 8';\n  -- Run your query here\n  ALTER SESSION SET EVENTS '10046 trace name context off';