-- Without LIMIT\nSELECT * FROM `user` WHERE `username` = 'nick';\n\n-- With LIMIT, which is more explicit about expecting a single result\nSELECT * FROM `user` WHERE `username` = 'nick' LIMIT 1;