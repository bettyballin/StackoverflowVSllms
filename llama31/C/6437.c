#include <gcc-plugin.h>\n#include <gimple.h>\n\n// Define the plugin's metadata\nstruct plugin_data {\n  const char *name;\n  const char *version;\n  const char *description;\n};\n\n// Define the plugin's callback function\nstatic unsigned int\nmy_pass_execute (void)\n{\n  // Get the current function\n  struct function *fun = cfun;\n\n  // Iterate over the function's basic blocks\n  basic_block bb;\n  FOR_EACH_BB_FN (bb, fun) {\n    // Iterate over the instructions in the basic block\n    gimple_stmt_iterator gsi;\n    for (gsi = gsi_start_bb (bb); !gsi_end_p (gsi); gsi_next (&gsi)) {\n      gimple *stmt = gsi_stmt (gsi);\n\n      // Check if the statement is a return statement\n      if (gimple_code (stmt) == GIMPLE_RETURN) {\n        // Insert a call to the dbg function before the return statement\n        gimple *dbg_stmt = gimple_build_call (builtin_decl_explicit (BUILT_IN_NORMAL, "__dbg"), 1, gimple_return_retval (stmt));\n        gsi_insert_before (&gsi, dbg_stmt, GSI_NEW_STMT);\n      }\n    }\n  }\n\n  return 0;\n}\n\n// Define the plugin's initialization function\nint\nplugin_init (struct plugin_name_args *plugin_info,\n             struct plugin_gcc_version *version)\n{\n  // Check if the plugin is compatible with the current GCC version\n  if (version->basever != 9) {\n    error ("plugin is not compatible with this version of GCC");\n    return 1;\n  }\n\n  // Register the plugin's callback function\n  register_callback (plugin_info->base_name, PLUGIN_PASS_MANAGER_SETUP, NULL, &my_pass_execute);\n\n  return 0;\n}