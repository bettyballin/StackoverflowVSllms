$result = $site->query('UPDATE `user_ips` SET `last_time` = UNIX_TIMESTAMP(), `user_agent` = \''.$this->user_agent.'\' WHERE `ip` = '.$this->ip.' AND `userid` = '.$this->id);\n$info = mysql_info();\nif ($info['rows_matched'] == 0) {\n    $site->query('INSERT INTO `user_ips` SET `userid` = '.$this->id.', `ip` = '.$this->ip.', `first_time` = UNIX_TIMESTAMP(), `last_time` = UNIX_TIMESTAMP(), `user_agent` = \''.$this->user_agent.'\'');\n}