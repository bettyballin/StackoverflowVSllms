SELECT field FROM test_table WHERE condition='test'\nINTO OUTFILE '/tmp/test.csv'\nFIELDS TERMINATED BY ','\nENCLOSED BY '\"'\nLINES TERMINATED BY '\n'\nLOCAL;