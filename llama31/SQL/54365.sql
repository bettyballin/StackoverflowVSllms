SELECT\n  users_usr.firstname_usr,\n  users_usr.lastname_usr,\n  credit_acc.given_credit_acc,\n  users_usr.created_usr,\n  users_usr.sitenum_usr,\n  users_usr.original_aff_usr,\n  users_usr.id_usr\nFROM\n  credit_acc\n  RIGHT OUTER JOIN users_usr \n  ON credit_acc.uid_usr = users_usr.id_usr \n  AND credit_acc.type_acc = 'init'