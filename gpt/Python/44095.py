import yfinance as yf\n\n# Define the ticker symbol\nticker = "AX-UN.TO"\n\n# Get the ticker data\nstock_data = yf.Ticker(ticker)\n\n# Get the stock info (summary, historical data, etc.)\ninfo = stock_data.info\nprint(info)