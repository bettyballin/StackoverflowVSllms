Map(x => x.YourPropertyName)\n       .CustomType<FixedLengthStringType>()\n       .Length(6)\n       .CustomSqlType("CHAR(6)");