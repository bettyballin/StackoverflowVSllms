insert into myTable\n    values(mybigtype('foo', 'bar', 'fizzle', myarrayoflittletypes(\n        (select ref(S)\n        from anotherTable S\n        where S.stname='dingle'),\n        (select ref(S)\n         from anotherTable S\n         where S.stname='fangle'))));