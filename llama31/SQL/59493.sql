CREATE FUNCTION do_and(int4) RETURNS boolean AS\n$$\n  SELECT bool_and(someBool) FROM myTable WHERE someKey = $1;\n$$\nLANGUAGE sql;