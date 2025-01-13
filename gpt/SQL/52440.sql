SELECT @AloneRecordCount = COUNT(i.id)\nFROM inserted i\nINNER JOIN deleted d ON i.id = d.id\nJOIN vwFundingDisbursement fd ON i.id = fd.settlementid\nWHERE i.StatusID = 32\n  AND d.StatusID <> 32\n  AND fd.DisbTypeName LIKE '%Alone'\n  AND fd.PaymentMethodID = 0