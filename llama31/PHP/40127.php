if (preg_match('~^(\d\d\d\d)(-(\d{1,2})(-(\d{1,2}))?)?$~', trim($date), $dateParts) && count($dateParts) > 2) {\n    // ...\n}