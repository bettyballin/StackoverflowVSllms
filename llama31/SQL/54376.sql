SELECT \n  email,\n  clear,\n  SUBSTRING_INDEX(email, '@', -1) AS domain\nFROM \n  postfix_users\nINTO OUTFILE '/path/to/output.csv'\nFIELDS ENCLOSED BY '\"'\nTERMINATED BY ','\nLINES TERMINATED BY '\n';