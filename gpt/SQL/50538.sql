WITH ReciprocalRelationships AS (\n    SELECT\n        LEAST(Person1, Person2) AS PersonA,\n        GREATEST(Person1, Person2) AS PersonB,\n        RelationshipType\n    FROM\n        Relationship\n    WHERE\n        RelationshipType = 'Married'\n),\nUniquePairs AS (\n    SELECT DISTINCT\n        PersonA,\n        PersonB\n    FROM\n        ReciprocalRelationships\n)\nSELECT\n    PersonA,\n    PersonB\nFROM\n    UniquePairs\nORDER BY\n    PersonA, PersonB;