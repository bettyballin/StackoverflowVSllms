EXPLAIN\nSELECT \n    users_usr.id_usr AS id_usr,\n    users_usr.firstname_usr AS firstname_usr,\n    users_usr.lastname_usr AS lastname_usr,\n    users_usr.social_usr AS social_usr,\n    users_usr.address1_usr AS address1_usr,\n    users_usr.address2_usr AS address2_usr,\n    users_usr.city_usr AS city_usr,\n    users_usr.state_usr AS state_usr,\n    users_usr.zip_usr AS zip_usr,\n    users_usr.email_usr AS email_usr,\n    credit_acc.given_credit_acc AS given_credit_acc,\n    credit_acc.credit_used_acc AS credit_used_acc,\n    credit_acc.date_established_acc AS date_established_acc,\n    credit_acc.type_acc AS type_acc,\n    credit_acc.bureau_status_acc AS bureau_status_acc,\n    SUM(credit_balance.debit_acc - credit_balance.credit_acc) AS balance\nFROM \n    users_usr\n    LEFT JOIN credit_acc ON users_usr.id_usr = credit_acc.uid_usr\n    LEFT JOIN cfc_cfc ON credit_acc.id_cfc = cfc_cfc.id_cfc\n    JOIN credit_acc credit_balance ON credit_balance.credit_used_acc = credit_acc.id_acc\nWHERE \n    credit_acc.type_acc = _latin1'init'\n    AND credit_acc.status_acc = _latin1'active'\n    AND credit_acc.linetype_acc = _latin1'personal'\nGROUP BY \n    credit_balance.credit_used_acc\nORDER BY \n    users_usr.id_usr;