SELECT \n  profile_option_name, \n  profile_option_value\nFROM \n  fnd_profile_options_vl\nWHERE \n  level_id = 'USER'\n  AND level_value = '&username';