$contact_name = 'foo';\n\nfunction do_something($args){\n    foreach ($args as $name => $value) {\n        echo $name . ' => ' . $value . "\n";\n    }\n}\n\ndo_something(array('contact_name' => $contact_name));