public DataTable GetFilteredOrders(int idOrder, string word1, string word2)\n{\n    return ordersTableAdapter.GetDataByCustomFilter(idOrder, word1, word2);\n}