def select_rows(to_select):\n    # Ensure to_select is a list\n    if not isinstance(to_select, list):\n        to_select = [to_select]\n    \n    # Common code to handle both list and single integer\n    for row in range(0, table.numRows()):\n        if _table.item(row, 1).text() in to_select:\n            table.selectRow(row)