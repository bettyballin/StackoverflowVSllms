SELECT b.B_data, c.C_data\nFROM tableB b\nINNER JOIN tableC c ON b.A_id = c.A_id;