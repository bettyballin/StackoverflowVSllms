select  SS.sightseeingId, SS.SightseeingName, SS.displayPrice,  MAX(SST.fromDate)\nfrom      tblSightseeings SS inner join \n              tblSightseeingTours SST on SS.sightseeingId =  SST.sightseeingId\nwhere    SS.isActive = 1 and SS.isDisplayOnMainPage = 1\nGROUP by SS.sightseeingId, SS.SightseeingName, SS.displayPrice