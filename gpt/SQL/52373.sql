Options (BindSize=10000000,Readsize=10000000,Rows=5000,Errors=100)\nLoad Data\nInfile 'XXX.txt'\nAppend into table T_XXX\nFields Terminated By ';'\nTRAILING NULLCOLS\n(\n    ...,\n    COMMENTS FILLER CHAR(1000), -- Adjust the size as per the maximum expected size in the CSV\n    ...\n)