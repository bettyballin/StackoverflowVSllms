SELECT @AloneRecordCount = COUNT(*)\nFROM inserted i\nINNER JOIN deleted d ON i.id = d.id\nWHERE i.StatusID = 32\n  AND d.StatusID <> 32\n  AND i.id IN\n  (\n    SELECT settlementid \n    FROM vwFundingDisbursement fd\n    WHERE fd.DisbTypeName LIKE '%Alone'\n      AND fd.PaymentMethodID = 0\n  )