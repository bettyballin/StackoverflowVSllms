SELECT order_no\nFROM orders\nGROUP BY order_no\nHAVING COUNT(suboperation) = COUNT(CASE WHEN finished IS NOT NULL THEN 1 END)