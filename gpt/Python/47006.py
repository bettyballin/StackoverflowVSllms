from openpyxl import Workbook\n\n# Create a workbook and select the active worksheet\nwb = Workbook()\nws = wb.active\n\n# Write data to the worksheet\nws['A1'] = "Hello"\nws['B1'] = "World"\n\n# Save the workbook\nwb.save("example.xlsx")