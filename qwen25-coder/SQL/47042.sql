Proc SQL;\n   Do While(1);\n      Delete From Server003.CustomerList Where 1 = 1 Limit 10000; /* Adjust limit as needed */\n      If SQLObs < 10000 Then Leave; /* Exit loop when no records left to delete */\n   End;\n   Quit;