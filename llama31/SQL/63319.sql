SELECT City1.name, City2.name, Distance(City1.coordinates, City2.coordinates)\nFROM Cities City1\nCROSS JOIN Cities City2\nWHERE City1.id <> City2.id