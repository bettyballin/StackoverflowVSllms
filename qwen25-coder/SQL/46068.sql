-- Example without global temp table\nCREATE VIEW my_view AS\nSELECT * FROM my_table WHERE date_column BETWEEN :start_date AND :end_date;