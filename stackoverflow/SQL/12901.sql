select case\n     when ISNUMERIC(T.Value) then T.Value \n     else SomeConversionFunction(T.Value)\n end as SomeAlias