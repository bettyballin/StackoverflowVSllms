UPDATE T1\nSET WorkerName = T2.WorkerID\nFROM T1\nJOIN T2 ON CHARINDEX(T2.WorkerName, T1.WorkerName) > 0