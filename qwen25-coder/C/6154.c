static void\nprocess_command (void)\n{\n  const char *argv0 = progname_get ();\n\n  if (strcmp (argv0, "g++") == 0 || strcmp (argv0, "gc++") == 0\n      || strcmp (argv0, "c++") == 0 || strcmp (argv0, "cxx") == 0)\n    {\n      default_target_os = "GNU";\n      default_target_cpu = "i386";\n      switch_to_language (lang_cplusplus);\n    }\n  // No specific handling for 'cc' or 'gcc', it continues with the defaults\n}