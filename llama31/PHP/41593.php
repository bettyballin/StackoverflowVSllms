$defined_vars = array_diff_key(get_defined_vars(), array_flip(array('_POST', '_GET', '_COOKIE', '_FILES', '_SERVER', '_ENV')));