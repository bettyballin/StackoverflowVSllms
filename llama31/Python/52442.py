def insert_ticker(session, ticker_set, new_ticker):\n    if new_ticker not in ticker_set:\n        session.add(Ticker(ticker=new_ticker))\n        session.commit()\n        ticker_set.add(new_ticker)\n\n# Example usage:\nnew_ticker = 'ABC123'\ninsert_ticker(session, ticker_set, new_ticker)