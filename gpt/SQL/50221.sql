ALTER TABLE my_table ADD COLUMN day DATE;\nALTER TABLE my_table ADD COLUMN month YEAR_MONTH;\nALTER TABLE my_table ADD COLUMN week YEAR_WEEK;\nALTER TABLE my_table ADD COLUMN year YEAR;\n\nCREATE INDEX idx_day ON my_table(day);\nCREATE INDEX idx_month ON my_table(month);\nCREATE INDEX idx_week ON my_table(week);\nCREATE INDEX idx_year ON my_table(year);