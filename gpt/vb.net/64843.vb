Dim id As Integer = 1\nDim nullId As Integer? = Nothing\nDim areEqual As Boolean\n\n' Using GetValueOrDefault\nareEqual = (nullId.GetValueOrDefault() = id) AndAlso nullId.HasValue\n\n' Or alternatively, you can use this approach\nDim areEqualNullable As Boolean? = (nullId = id)\nareEqual = areEqualNullable.GetValueOrDefault(False)