MatchedQuotes = re.compile(r"(['\"])(.*)\1", re.LOCALE)\nitem = MatchedQuotes.sub(r'\2', item, 1)