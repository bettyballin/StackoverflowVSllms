SELECT * FROM MyTable\nWHERE NLSSORT(MyField, 'NLS_SORT=BINARY_CI_AI') = NLSSORT('BobDillon', 'NLS_SORT=BINARY_CI_AI');