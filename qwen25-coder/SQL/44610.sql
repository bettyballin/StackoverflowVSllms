WITH LatestPrices AS (\n    SELECT Partid, MAX(PriceDate) AS MaxPriceDate\n    FROM MyPrices\n    GROUP BY Partid\n)\nSELECT \n    mp.Partid,\n    mp.Partnumber,\n    mp.Description,\n    p.Price\nFROM \n    MyParts mp\nLEFT JOIN \n    LatestPrices lp ON mp.Partid = lp.Partid\nLEFT JOIN \n    MyPrices p ON lp.Partid = p.Partid AND lp.MaxPriceDate = p.PriceDate;