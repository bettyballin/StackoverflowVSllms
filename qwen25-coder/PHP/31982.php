$args = array($id);\n$result = call_user_func_array(array("myclass", "factory"), $args);\n\n// Debugging output\nerror_log(print_r($args, true));