INSERT INTO myTable\nSELECT mybigtype('foo', 'bar', 'fizzle', \n       CAST(COLLECT(REF(S)) AS myarrayoflittletypes))\nFROM anotherTable S\nWHERE S.stname = 'dingle' OR S.stname = 'fangle';