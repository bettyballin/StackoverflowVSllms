var ids = new List<int> {1, 2, 3}; // example list\n   var result = from record in db.Records\n                where ids.Contains(record.Id)\n                select record;