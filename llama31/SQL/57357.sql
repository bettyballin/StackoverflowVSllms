UPDATE ptm\n  SET ptm.PTAmount = ptm.PTAmount + pts.PTAmount\nFROM PayrollTotals ptm\nINNER JOIN PayrollTotals pts\n  ON ptm.PTEmpID = pts.PTEmpID\n  AND pts.PTACID = 38\nWHERE ptm.PTACID = 42