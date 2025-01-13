CREATE TABLE #MonthlySalesAgg\n(\n    SalesManCode int,\n    JanTar money,\n    FebTar money,\n    MarTar money,\n    AprTar money,\n    MayTar money,\n    JunTar money,\n    JulTar money,\n    AugTar money,\n    SepTar money,\n    OctTar money,\n    NovTar money,\n    DecTar money\n\n    PRIMARY KEY CLUSTERED (SalesManCode)\n)\n\nINSERT INTO #MonthlySalesAgg\nSELECT *\nFROM\n(SELECT SalesManCode, TargetValue, SaleMonth = Month(TargetDate) FROM MonthlyTarget) as temp\nPIVOT\n(\n    Max(TargetValue)\n    FOR [SaleMonth] IN ([1],[2],[3],[4],[5],[6],[7],[8],[9],[10],[11],[12])\n) as p\n\nCREATE TABLE #MonthlyTargetAgg\n(\n    SalesManCode int,\n    JanAch money,\n    FebAch money,\n    MarAch money,\n    AprAch money,\n    MayAch money,\n    JunAch money,\n    JulAch money,\n    AugAch money,\n    SepAch money,\n    OctAch money,\n    NovAch money,\n    DecAch money\n\n    PRIMARY KEY CLUSTERED (SalesManCode)\n)\n\nINSERT INTO #MonthlyTargetAgg\nSELECT * FROM\n(SELECT SalesManCode, AchievedValue, SaleMonth = Month(SaleDate) FROM MonthlySales) as temp\nPIVOT\n(\n    Sum(AchievedValue)\n    FOR [SaleMonth] IN ([1],[2],[3],[4],[5],[6],[7],[8],[9],[10],[11],[12])\n) as p