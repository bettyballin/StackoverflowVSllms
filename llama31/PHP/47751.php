$disallowedSubdomains = array('www', 'nosub');\nif (!in_array($subdom, $disallowedSubdomains)) {\n    // do some stuff if the subdomain is not in the disallowed list\n}