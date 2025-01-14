SELECT \n    REPLACE(StudentType, 'StudentType', '') AS DemographicType,\n    Population,\n    PopulationAdjustment,\n    Sales,\n    SalesAdjustment\nFROM \n(\n    SELECT \n        ClientId,\n        TermId,\n        StudentType1Population AS StudentType1_Population,\n        StudentType2Population AS StudentType2_Population,\n        StudentType3Population AS StudentType3_Population,\n        StudentType4Population AS StudentType4_Population,\n        StudentType5Population AS StudentType5_Population,\n        StudentType1Adjustment AS StudentType1_PopulationAdjustment,\n        StudentType2Adjustment AS StudentType2_PopulationAdjustment,\n        StudentType3Adjustment AS StudentType3_PopulationAdjustment,\n        StudentType4Adjustment AS StudentType4_PopulationAdjustment,\n        StudentType5Adjustment AS StudentType5_PopulationAdjustment,\n        StudentType1Sales AS StudentType1_Sales,\n        StudentType2Sales AS StudentType2_Sales,\n        StudentType3Sales AS StudentType3_Sales,\n        StudentType4Sales AS StudentType4_Sales,\n        StudentType5Sales AS StudentType5_Sales,\n        StudentType1SalesAdjustment AS StudentType1_SalesAdjustment,\n        StudentType2SalesAdjustment AS StudentType2_SalesAdjustment,\n        StudentType3SalesAdjustment AS StudentType3_SalesAdjustment,\n        StudentType4SalesAdjustment AS StudentType4_SalesAdjustment,\n        StudentType5SalesAdjustment AS StudentType5_SalesAdjustment\n    FROM ClientSales\n    WHERE ClientId = 1 AND TermId = 1\n) p\nUNPIVOT \n(\n    Population FOR StudentType IN (\n        StudentType1_Population, \n        StudentType2_Population, \n        StudentType3_Population, \n        StudentType4_Population, \n        StudentType5_Population\n    )\n) AS UnPvtPopulation\nUNPIVOT\n(\n    PopulationAdjustment FOR StudentType IN (\n        StudentType1_PopulationAdjustment, \n        StudentType2_PopulationAdjustment, \n        StudentType3_PopulationAdjustment, \n        StudentType4_PopulationAdjustment, \n        StudentType5_PopulationAdjustment\n    )\n) AS UnPvtPopulationAdjustment\nUNPIVOT\n(\n    Sales FOR StudentType IN (\n        StudentType1_Sales, \n        StudentType2_Sales, \n        StudentType3_Sales, \n        StudentType4_Sales, \n        StudentType5_Sales\n    )\n) AS UnPvtSales\nUNPIVOT\n(\n    SalesAdjustment FOR StudentType IN (\n        StudentType1_SalesAdjustment, \n        StudentType2_SalesAdjustment, \n        StudentType3_SalesAdjustment, \n        StudentType4_SalesAdjustment, \n        StudentType5_SalesAdjustment\n    )\n) AS UnPvtSalesAdjustment\nWHERE REPLACE(StudentType, '_Population', '') = REPLACE(UnPvtPopulation.StudentType, 'StudentType', '')\nAND REPLACE(StudentType, '_Sales', '') = REPLACE(UnPvtSales.StudentType, 'StudentType', '')\nAND REPLACE(StudentType, '_SalesAdjustment', '') = REPLACE(UnPvtSalesAdjustment.StudentType, 'StudentType', '');