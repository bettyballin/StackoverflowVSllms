Dim runTimeResourceSet As Object\n    Dim dictEntry As DictionaryEntry\n\n    runTimeResourceSet = My.Resources.ResourceManager.GetResourceSet(System.Globalization.CultureInfo.CurrentCulture, False, True)\n    For Each dictEntry In runTimeResourceSet\n        If (dictEntry.Value.GetType() Is GetType(Icon)) Then\n            Console.WriteLine(dictEntry.Key)\n        End If\n    Next