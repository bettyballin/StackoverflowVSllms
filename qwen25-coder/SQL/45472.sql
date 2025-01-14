SELECT ph.*\nFROM ProductPriceHistory ph\nJOIN (\n    SELECT ProductCode, MAX(EffectDate) AS LatestEffectDate\n    FROM ProductPriceHistory\n    WHERE IsActive = true\n    GROUP BY ProductCode\n) latest ON ph.ProductCode = latest.ProductCode AND ph.EffectDate = latest.LatestEffectDate;