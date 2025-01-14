WITH min_prices AS (\n  SELECT location_id, MIN(price) AS min_price\n  FROM thing\n  INNER JOIN location ON (thing.location_id = location.id)\n  WHERE type = xxx\n  GROUP BY location_id\n)\n\nSELECT t.*\nFROM thing t\nJOIN min_prices mp ON (t.location_id = mp.location_id AND t.price = mp.min_price);