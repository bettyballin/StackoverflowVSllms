SELECT id,question FROM `questions` \nWHERE `sort_order` > sort_order_variable\nORDER BY sort_order ASC \nLIMIT 1