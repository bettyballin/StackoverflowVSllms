var customerEntity = new Shopper\n{\n    shopper_id = CustomerData.CustomerID,\n    market_code = CustomerData.MarketSector,\n    email = CustomerData.Email,\n    modified = DateTime.Now\n};\n\ncontext.Entry(customerEntity).Property(e => e.created).IsModified = false;\ncontext.Entry(customerEntity).State = EntityState.Modified;\ncontext.SaveChanges();