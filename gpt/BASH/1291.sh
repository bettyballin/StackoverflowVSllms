PHP_ARG_ENABLE(foo, whether to enable foo support,\n[ --enable-foo Enable foo support])\n\nif test "$PHP_FOO" != "no"; then\n  PHP_NEW_EXTENSION(foo, foo_wrap.c foo.c, $ext_shared)\nfi