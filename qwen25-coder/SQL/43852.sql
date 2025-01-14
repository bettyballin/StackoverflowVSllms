CREATE SECURITY POLICY UserMessagesPolicy\nADD FILTER PREDICATE SchemaName.SecurityPredicate(RecipientColumn)\nON users.MESSAGES,\nADD BLOCK PREDICATE SchemaName.SecurityPredicate(RecipientColumn)\nON users.MESSAGES AFTER INSERT;