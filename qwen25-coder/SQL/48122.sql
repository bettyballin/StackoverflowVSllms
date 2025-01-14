SELECT SS.sightseeingId AS 'sID'\n     , SS.SightseeingName\n     , SS.displayPrice AS 'Price'\n     , MIN(SST.fromDate) AS fromDate \nFROM tblSightseeings SS INNER JOIN \n     tblSightseeingTours SST ON SS.sightseeingId =  SST.sightseeingId\nWHERE SS.isActive = 1 AND SS.isDisplayOnMainPage = 1 \nGROUP BY SS.sightseeingId, SS.SightseeingName, SS.displayPrice;