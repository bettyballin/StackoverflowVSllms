Zend_Registry::set('timezone', 'Australia/ACT');\n\n$date = new Zend_Date('2009-01-01 10:30:00', Zend_Date::ISO_8601);\n$date->setTimezone(Zend_Registry::get('timezone'));\necho $date->get(Zend_Date::TIME_MEDIUM); //21:30:00