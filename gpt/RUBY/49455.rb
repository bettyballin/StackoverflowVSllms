# Calculate total revenue grouped by customer\ntotal_revenue_by_customer = Order.group(:customer_id).sum(:amount)\n\n# Calculate average order amount grouped by customer\naverage_order_by_customer = Order.group(:customer_id).average(:amount)