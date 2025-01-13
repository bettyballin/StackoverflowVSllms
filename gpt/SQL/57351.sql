SELECT \n    r.percent_premium * @suminsured AS premium\nFROM \n    ratings r\nWHERE \n    r.goods_type = @goods_type\n    AND @suminsured BETWEEN r.suminsured_min AND r.suminsured_max;