SELECT * FROM MyTable\nWHERE NLSSORT(MyField, 'NLS_SORT = BINARY_CI') = NLSSORT('BobDillon', 'NLS_SORT = BINARY_CI');