// Set the locale depending on user preference or IP lookup, etc.\n$locale = 'fr_FR.UTF-8';\nputenv("LANG=$locale");\nsetlocale(LC_ALL, $locale);\n\n// Specify the location of the translation files\nbindtextdomain('myapp', '/path/to/locale');\n\n// Choose which domain to use (default is messages)\ntextdomain('myapp');\n\necho _("Welcome to our website");