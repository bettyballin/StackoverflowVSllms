Select TableA.*, TableB.*\nfrom TableA \nLeft Join TableB \non (TableA.fld1 = TableB.fld2 AND TableB.fld4 = false)\nwhere TableA.fld3 = True;