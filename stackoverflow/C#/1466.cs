Object obj = APRegistry.GetValue("apTime");\nString str = obj != null ? obj.ToString() : "0";\nDecimal value = Decimal.Parse(str);\nthis.apTime.Value = value;