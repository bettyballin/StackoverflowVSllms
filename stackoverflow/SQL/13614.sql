where\n(upper(Company)=upper(@CompName) or @compName = 'ALL COMPANIES')\nand \n(OfficeID=@CompBranchId or @CompBranchId = 'ALL OFFICES')\nand\n(StateID=@StateID or @StateID = 'ALL States')