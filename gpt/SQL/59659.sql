SELECT terms, COUNT(*) as frequency\nFROM searchterms\nGROUP BY terms\nORDER BY frequency DESC;