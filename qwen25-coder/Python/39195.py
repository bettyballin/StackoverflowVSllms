from xlrd import open_workbook\nimport csv\n\ndef main():\n    workbook = open_workbook('file.xls')\n    sheet = workbook.sheet_by_name('Export')\n\n    with open('file.csv', 'w', newline='', encoding='utf-8') as csvfile:\n        writer = csv.writer(csvfile)\n        for row_idx in range(sheet.nrows):\n            this_row = []\n            for col_idx in range(sheet.ncols):\n                cell_value = sheet.cell_value(row_idx, col_idx)\n                # Encode Unicode to UTF-8\n                if isinstance(cell_value, str):  # Check if the value is a string\n                    cell_value = cell_value.encode('utf-8').decode('utf-8')\n                this_row.append(cell_value)\n            writer.writerow(this_row)\n\nif __name__ == "__main__":\n    main()