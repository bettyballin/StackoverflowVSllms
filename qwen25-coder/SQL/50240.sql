UPDATE YourTable\nSET YourDateColumn = DATEADD(MONTH, @NewMonth - DATEPART(MONTH, YourDateColumn), YourDateColumn)\nWHERE YourCondition;