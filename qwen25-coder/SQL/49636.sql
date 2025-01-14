CREATE TABLE `categories` (\n  `cID` bigint(20) NOT NULL AUTO_INCREMENT,\n  -- other fields...\n  PRIMARY KEY (`cID`)\n) ENGINE=InnoDB;\n\nCREATE TABLE `users` (\n  `uID` bigint(20) NOT NULL AUTO_INCREMENT,\n  -- other fields...\n  PRIMARY KEY (`uID`)\n) ENGINE=InnoDB;\n\nCREATE TABLE `posts` (\n  `pID` bigint(20) NOT NULL AUTO_INCREMENT,\n  `content` text NOT NULL,\n  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n  `uID` bigint(20) NOT NULL,\n  `wikiptr` bigint(20) DEFAULT NULL,\n  `cID` bigint(20) NOT NULL,\n  PRIMARY KEY (`pID`),\n  FOREIGN KEY (`uID`) REFERENCES users(`uID`),\n  FOREIGN KEY (`cID`) REFERENCES categories(`cID`)\n) ENGINE=InnoDB;