UPDATE sometable \nSET \n        price1 =        ISNULL(@param1, price1),\n        price2 =        ISNULL(@param2, price2),\n        price3 =        ISNULL(@param3, price3),\n        price4 =        ISNULL(@param4, price4)\nWHERE\n        ID = @param5