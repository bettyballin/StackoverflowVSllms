Dim x = (From y In context.MyTable \n         Where y.MyField = value \n         Select y.MyCounter).DefaultIfEmpty(defaultValue).Max()