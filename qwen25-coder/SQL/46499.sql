SELECT *\nINTO #FilteredFact\nFROM FactTable\nWHERE Date >= '2023-01-01';\n\nSELECT f.*, d.DimensionName\nFROM #FilteredFact f\nJOIN DimTable d ON f.DimensionID = d.ID;\n\nDROP TABLE #FilteredFact;