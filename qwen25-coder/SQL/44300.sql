SELECT affiliates.loginid \nFROM affiliates \nLEFT JOIN referrers ON affiliates.id = referrers.affiliates_id \nWHERE referrers.id IS NULL;