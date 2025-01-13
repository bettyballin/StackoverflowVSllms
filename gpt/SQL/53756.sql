SELECT p.ProductID, \n       COALESCE(t.TranslatedText, p.OriginalName) AS ProductName\nFROM Products p\nLEFT JOIN Translations t ON p.ProductID = t.RowID \n                         AND t.TableName = 'Products' \n                         AND t.ColumnName = 'ProductName'\n                         AND t.LanguageCode = @languageCode\nWHERE t.TranslatedText IS NOT NULL OR @languageCode = 'en';