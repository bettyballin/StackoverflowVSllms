CREATE TABLE `ci_sessions` (\n    `id` varchar(128) NOT NULL,\n    `ip_address` varchar(45) NOT NULL,\n    `timestamp` int(10) unsigned DEFAULT 0 NOT NULL,\n    `data` blob NOT NULL,\n    KEY `ci_sessions_timestamp` (`timestamp`)\n);