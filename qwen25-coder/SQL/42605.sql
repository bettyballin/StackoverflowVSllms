SELECT u.* \nFROM user u \nLEFT JOIN CONTACT_INFO c ON u.user_id = c.user_id \nWHERE c.user_id IS NULL;