UPDATE your_table\nSET Amount = (SELECT Amount FROM your_table WHERE AccNo = 2040)\nWHERE AccNo = 1020;