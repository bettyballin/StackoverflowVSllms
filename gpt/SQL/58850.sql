SELECT w.WorkerID\nFROM tb_Worker w\nJOIN tb_Manager m ON w.ManagerID = m.ManagerID\nJOIN tb_Head h ON m.HeadID = h.HeadID\nWHERE h.HeadID = @GivenHeadID;