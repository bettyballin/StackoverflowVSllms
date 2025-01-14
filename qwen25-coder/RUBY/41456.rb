# Assuming you have a model named FinancialTransaction\ntotal_amount = FinancialTransaction.sum(:amount)\naverage_transaction = FinancialTransaction.average(:amount)\n\n# Grouping by an attribute, e.g., month and year from a date column\nmonthly_totals = FinancialTransaction.group("DATE_FORMAT(date_column, '%Y-%m')").sum(:amount)