SELECT * \nFROM table \nWHERE first_name LIKE CONCAT('%', ?, '%') \n   OR last_name LIKE CONCAT('%', ?, '%') \n   OR CONCAT_WS(' ', first_name, last_name) LIKE CONCAT('%', ?, '%');