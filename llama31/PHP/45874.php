$domain = 'mydomain';\n$locale_dir = '/path/to/locale/files';\n\n$catalog = gettext($domain, $locale_dir);\n$msgids = array_keys($catalog);\n\nforeach ($msgids as $msgid) {\n    do_something_awesome($msgid);\n}