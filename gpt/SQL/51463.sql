SELECT order_no\nFROM orders\nGROUP BY order_no\nHAVING COUNT(suboperation) = COUNT(finished);