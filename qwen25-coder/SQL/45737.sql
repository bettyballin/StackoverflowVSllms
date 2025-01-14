CREATE TABLE `user_similarity` (\n  `userid1` int NOT NULL,\n  `userid2` int NOT NULL,\n  `similarity` float DEFAULT NULL,\n  PRIMARY KEY (`userid1`,`userid2`)\n);\n\n-- Insert similarity data into the table\nINSERT INTO `user_similarity` (userid1, userid2, similarity)\nVALUES (1, 2, 0.4), (1, 3, 0.2), ...;