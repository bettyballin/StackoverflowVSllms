CREATE TABLE mytable (\n  mydate DATE CHECK (TO_CHAR(mydate, 'D') != '1')\n);