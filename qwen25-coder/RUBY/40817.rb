def avg_sales_per_day(start_date, end_date)\n  # Fetch all sales within the specified merchant's id and date range\n  sales = ProductSold.where(merchant_id: 1, created_at: start_date..end_date)\n  \n  # Group by day and calculate averages\n  daily_averages = {}\n  (start_date.to_date..end_date.to_date).each do |date|\n    daily_sales = sales.select { |sale| sale.created_at.to_date == date }\n    average = daily_sales.present? ? (daily_sales.sum(&:sales_price).to_f / daily_sales.size) : 0\n    daily_averages[date] = average.round(2)\n  end\n  \n  # Convert to an array of hashes for graphing or other purposes\n  daily_averages.map { |date, avg| { date: date.strftime('%m-%d-%Y'), avg: avg } }\nend\n\n# Example usage:\naverage_sales = avg_sales_per_day(Date.new(2009, 1, 3), Date.new(2009, 1, 8))\nputs average_sales