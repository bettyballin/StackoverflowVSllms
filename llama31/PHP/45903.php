$timezone = 'Australia/Melbourne';\n$dt = new DateTime('now', new DateTimeZone($timezone));\n$formatter = new IntlDateFormatter('en_AU', IntlDateFormatter::NONE, IntlDateFormatter::NONE);\n$formatter->setTimeZone($dt->getTimeZone());\necho $formatter->getPattern('zzz'); // Output: AEST