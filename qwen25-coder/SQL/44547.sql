-- First, select PublicationIDs based on AdvertiserID and LastAdDate condition\nSELECT DISTINCT pat.PublicationID\nFROM dbo.PubAdvTransData AS pat \nINNER JOIN dbo.PubAdvertiser AS pa ON pat.AdvTransID = pa.AdvTransID\nWHERE pa.AdvertiserID = 31331 AND pat.LastAdDate > '2009-01-07'\n\nUNION\n\n-- Then, get the AreaBuyIDs that match the PublicationIDs from the above query\nSELECT DISTINCT ab.AreaBuyID AS PublicationID\nFROM AreaBuy AS ab\nINNER JOIN PublicationsAreaBuy AS pubab ON ab.AreaBuyID = pubab.AreaBuyID\nINNER JOIN dbo.PubAdvTransData AS pat ON pat.PublicationID = pubab.PublicationID\nINNER JOIN dbo.PubAdvertiser AS pa ON pat.AdvTransID = pa.AdvTransID\nWHERE pa.AdvertiserID = 31331 AND pat.LastAdDate > '2009-01-07'\n\nORDER BY PublicationID;