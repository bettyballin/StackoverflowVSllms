SELECT\n  id,\n  street_name\nFROM\n  street_names\nWHERE\n  street_name REGEXP '^(rue[a-z]+[[:blank:]])((du|de|la|des|d\\'|l\\')[[:blank:]])*[[:<:]]HARMONIE$'