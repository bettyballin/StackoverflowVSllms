BEGIN\n   FOR R IN (SELECT owner, table_name FROM all_tables WHERE owner='TheOwner') LOOP\n      EXECUTE IMMEDIATE 'grant select on '||R.owner||'.'||R.table_name||' to TheUser';\n   END LOOP;\nEND; 