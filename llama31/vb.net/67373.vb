Dim id As Integer = 1\nDim nullId As Integer? = Nothing\nDim areEqual As Boolean\n\n' Using GetValueOrDefault\nareEqual = (nullId.GetValueOrDefault() = id)\n\n' Using null-conditional operator\nareEqual = (nullId.HasValue AndAlso nullId.Value = id)