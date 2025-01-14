WITH RecursiveGroups AS (\n    SELECT kgl.Kunde_ID, g.Gruppe_ID, g.Navn, g.OverordnetGruppe_ID, 0 AS Level\n    FROM Gruppe g\n    JOIN KundeGruppeLink kgl ON kgl.Gruppe_ID = g.Gruppe_ID\n\n    UNION ALL\n\n    SELECT rg.Kunde_ID, g.Gruppe_ID, g.Navn, g.OverordnetGruppe_ID, rg.Level + 1\n    FROM Gruppe g\n    INNER JOIN RecursiveGroups rg ON g.OverordnetGruppe_ID = rg.Gruppe_ID\n)\nSELECT DISTINCT k.Kunde_ID, k.Navn AS Kundenavn,\n       REPLICATE('   - ', Level) + rg.Navn AS NavnUnderGrupper\nFROM Kunde k\nJOIN RecursiveGroups rg ON k.Kunde_ID = rg.Kunde_ID\nORDER BY k.Kunde_ID, rg.Level, rg.Gruppe_ID;