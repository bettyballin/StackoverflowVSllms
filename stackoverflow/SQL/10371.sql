LIST(\n    case when tblWOService.PricePerVehicle is null then CONVERT(decimal(19,2),' ')\n        else CONVERT(decimal(19,2),tblWOService.PricePerVehicle) end,';'\n)