create or replace package body JUMPTO is\n\n  procedure procGetLocations(locations out t_locations) is\n  begin\n    open locations for \n      select * from your_table_name; -- Replace `your_table_name` with the actual table name you want to query.\n  end;\n\nend JUMPTO;