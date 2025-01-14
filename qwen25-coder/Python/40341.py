from openpyxl import load_workbook\n\n   # Load an existing workbook\n   wb = load_workbook('example.xlsx')\n   sheet = wb.active\n   print(sheet['A1'].value)\n\n   # Modify the data\n   sheet['A1'] = 'Hello, world!'\n\n   # Save the workbook\n   wb.save('modified_example.xlsx')