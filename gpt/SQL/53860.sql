BEGIN TRANSACTION;\n\nUPDATE accounts\nSET balance = balance - amount\nWHERE ac_num = 101;\n\nUPDATE accounts\nSET balance = balance + amount\nWHERE ac_num = 102;\n\nCOMMIT;