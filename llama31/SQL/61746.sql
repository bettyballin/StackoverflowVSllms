SELECT o.OrderId, \n       IIF(o.NegotiatedPrice > o.SuggestedPrice, o.NegotiatedPrice, o.SuggestedPrice) AS MaxPrice\nFROM Order o