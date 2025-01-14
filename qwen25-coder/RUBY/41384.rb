# Using find_by_sql for a complex query\nresults = FinancialTransaction.find_by_sql("SELECT date_trunc('month', transaction_date) AS month, SUM(amount) FROM financial_transactions GROUP BY month")\n\n# Or scoping with raw SQL fragments\nFinancialTransaction.where("amount > ?", 1000).select("user_id, AVG(amount) AS avg_purchase", "SUM(amount) as total_spent").group(:user_id)