SELECT\n    this.Column1,\n    CASE WHEN this.Column2 IS NULL THEN 0 ELSE this.Column2 END\nFROM dbo.SomeTable this\n    INNER JOIN dbo.AnotherTable another ON this.id = another.id\nWHERE\n    this.Price > 100;