SELECT F.name\nFROM Foo F\nLEFT JOIN Bar B ON F.id = B.fooId AND B.value > 0\nWHERE B.fooId IS NULL