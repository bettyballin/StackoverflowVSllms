SELECT * FROM your_table \nSTART WITH parent_id IS NULL\nCONNECT BY PRIOR id = parent_id;