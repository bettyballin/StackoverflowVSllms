string currentUICulture = Thread.CurrentThread.CurrentUICulture.Name;\nProduct p = DALProduct.GetByID(2, currentUICulture);\nConsole.WriteLine(p.Name); // results in the language of the current UICulture