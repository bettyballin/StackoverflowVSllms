SELECT  INVITEM.CharId AS CharId, \n        INVITEM.ItemId AS ItemId \nFROM  INVITEM \nINNER JOIN  SHOPITEM \nUSING (ItemId)\nWHERE  ItemId = 3;