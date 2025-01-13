SELECT tb.*\nFROM (\n    SELECT vCodesWithPEs.PROD_PERM, vCodesWithPEs.Column1, vCodesWithPEs.Column2, -- specify required columns from vCodesWithPEs\n           vDeriveAvailabilityFromPE.ColumnA, vDeriveAvailabilityFromPE.ColumnB, -- specify required columns from vDeriveAvailabilityFromPE\n           PE_PDP.ColumnX, PE_PDP.ColumnY -- specify required columns from PE_PDP\n    FROM vCodesWithPEs \n    INNER JOIN vDeriveAvailabilityFromPE ON vCodesWithPEs.PROD_PERM = vDeriveAvailabilityFromPE.PEID\n    INNER JOIN PE_PDP ON vCodesWithPEs.PROD_PERM = PE_PDP.PEID\n) AS tb;