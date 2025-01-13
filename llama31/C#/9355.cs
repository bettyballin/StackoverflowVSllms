var contacts = from c in db.Contacts\n               join ca in db.ContactAddresses on c.Id equals ca.ContactId into caGroup\n               from ca in caGroup.DefaultIfEmpty()\n               select new { Contact = c, Address = ca };