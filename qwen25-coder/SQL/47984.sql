INSERT INTO Users (id, weight, desiredWeight) VALUES (1, 160, 145)\nON DUPLICATE KEY UPDATE weight = 160, desiredWeight = 145;