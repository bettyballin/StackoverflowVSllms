Dim query = From cust In customers\n            Where cust.City = "London"\n            Select cust.Name, cust.Phone