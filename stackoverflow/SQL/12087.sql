INSERT INTO jss_info_requests_table \n (users_id, provider_id, subcategories_id)\nSELECT a.users_id,\n b.provider_id, b.subcategories_id FROM\n jss_users_interests_table a,\n jss_providers_assignments_table b \n WHERE a.subcategories_id =\n b.subcategories_id AND a.users_id =\n [USERID]