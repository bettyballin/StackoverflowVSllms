Dim foo As Dictionary(Of String, String)\nfoo.Add("k1", Nothing)\nfoo.Add("k2", "something")\n\nDim IDictionary(Of String, String) res = foo _\n    .Where(Function(x) Not String.IsNullOrEmpty(x.Value)) _\n    .ToDictionary(Function(x) x.Key, Function(y) y.Value)