SELECT p.ID, p.PRODUCT_NAME, p.COLOR, p.SALE_COUNT\nFROM products p\nWHERE p.PRODUCT_NAME LIKE '%:searchTerm%' AND (p.COLOR = :searchColor OR :searchColor IS NULL);