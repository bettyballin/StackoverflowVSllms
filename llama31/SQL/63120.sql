-- SSIS Merge Join equivalent\nSELECT \n    A.Account,\n    G.Customer\nFROM \n    Accounts A\nINNER JOIN \n    Groups G ON G.GroupName BETWEEN A.LowerGroup AND A.UpperGroup