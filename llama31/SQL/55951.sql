SELECT id FROM plants WHERE Flower REGEXP CONCAT('[[:<:]]', ?, '[[:>:]]')