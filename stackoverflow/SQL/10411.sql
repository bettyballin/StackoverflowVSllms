SELECT *\nFROM MyTable\nWHERE NLSSORT(MyField, 'NLS_SORT = Latin_AI') = NLSSORT('BobDillon', 'NLS_SORT = Latin_AI')