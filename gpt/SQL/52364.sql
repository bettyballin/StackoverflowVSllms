INSERT INTO myTable\nSELECT mybigtype('foo', 'bar', 'fizzle', \n                 CAST(MULTISET(\n                    SELECT REF(S)\n                    FROM anotherTable S\n                    WHERE S.stname IN ('dingle', 'fangle')\n                 ) AS myarrayoflittletypes))\nFROM dual;