DateTime myDateTime = new DateTime(2008, 12, 28); // Example date\nstring formattedDate = myDateTime.ToString("yyyy-MM-dd");\n\nmyBindingSource.Filter = $"CONVERT(myDateField, 'System.String') LIKE '{formattedDate}%'";