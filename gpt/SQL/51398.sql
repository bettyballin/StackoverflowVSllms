CREATE TABLE `users` (\n    `uID` bigint(20) NOT NULL auto_increment,\n    `username` varchar(50) NOT NULL,\n    PRIMARY KEY (`uID`)\n) ENGINE=InnoDB;\n\nCREATE TABLE `categories` (\n    `cID` bigint(20) NOT NULL auto_increment,\n    `category_name` varchar(50) NOT NULL,\n    PRIMARY KEY (`cID`)\n) ENGINE=InnoDB;