$data = array(\n    'logins' => new Zend_Db_Expr('logins + 1')\n);\n\n$n = $db->update('users', $data, 'user_id = '.$_userId);