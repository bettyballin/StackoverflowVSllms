CREATE VIEW TodayView AS\nSELECT *\nFROM `your_table`\nWHERE DATE(`Date`) = CURRENT_DATE();