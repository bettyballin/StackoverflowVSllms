SELECT \n  profile_option_name, \n  level_id, \n  level_value, \n  profile_option_value\nFROM \n  fnd_profile_options_vl\nWHERE \n  level_id IN ('SITE', 'APP', 'RESP', 'USER')\nORDER BY \n  profile_option_name, \n  level_id, \n  level_value;