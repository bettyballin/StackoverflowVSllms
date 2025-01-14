SELECT \n    r.ID AS ShippingRateID, \n    r.Name, \n    CASE \n        WHEN e.Price IS NOT NULL THEN e.Price \n        ELSE r.Price \n    END AS ShippingPrice\nFROM \n    shipping r \nLEFT JOIN \n    shippingexceptions e \nON \n    r.ID = e.ShippingRateID \n    AND e.ProductID = 48