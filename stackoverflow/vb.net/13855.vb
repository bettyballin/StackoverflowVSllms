Selection.Find.ClearFormatting\nSelection.Find.Replacement.ClearFormatting\nWith Selection.Find\n    .Text = "test"\n    .Replacement.Text = "test2"\n    .Forward = True\n    .Wrap = wdFindContinue\n    .Format = False\n    .MatchCase = False\n    .MatchWholeWord = False\n    .MatchKashida = False\n    .MatchDiacritics = False\n    .MatchAlefHamza = False\n    .MatchControl = False\n    .MatchWildcards = False\n    .MatchSoundsLike = False\n    .MatchAllWordForms = False\nEnd With\nSelection.Find.Execute Replace:=wdReplaceAll