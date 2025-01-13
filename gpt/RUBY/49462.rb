# lib/formatting_helpers.rb\nmodule FormattingHelpers\n  def format_date(date)\n    date.strftime("%B %d, %Y")\n  end\n\n  def format_currency(amount)\n    sprintf("$%.2f", amount)\n  end\nend