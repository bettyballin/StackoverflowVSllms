Print 'Selecting From Table Containing Junk'\nSELECT * \nFROM Phones \nWHERE TRY_CONVERT(bigint, Mobile) = @biMobile_1  -- Select #2\n\nSELECT * \nFROM Phones \nWHERE TRY_CONVERT(bigint, Mobile) = @biMobile_2; -- Select #3