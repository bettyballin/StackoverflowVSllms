SELECT \n    contracts.field1, \n    contracts.field2, \n    sp1.first_name AS sp1_first_name, \n    sp1.last_name AS sp1_last_name, \n    sp2.first_name AS sp2_first_name, \n    sp2.last_name AS sp2_last_name, \n    sobc.first_name AS sobc_first_name, \n    sobc.last_name AS sobc_last_name, \n    csc1.first_name AS csc1_first_name, \n    csc1.last_name AS csc1_last_name, \n    csc2.first_name AS csc2_first_name, \n    csc2.last_name AS csc2_last_name, \n    cbc.first_name AS cbc_first_name, \n    cbc.last_name AS cbc_last_name\nFROM contracts\nJOIN users AS sp1 ON contracts.service_provider_1 = sp1.username\nJOIN users AS sp2 ON contracts.service_provider_2 = sp2.username\nJOIN users AS sobc ON contracts.service_org_business_contact = sobc.username\nJOIN users AS csc1 ON contracts.client_service_contact_1 = csc1.username\nJOIN users AS csc2 ON contracts.client_service_contact_2 = csc2.username\nJOIN users AS cbc ON contracts.client_business_contact = cbc.username\nWHERE contracts.id = ?