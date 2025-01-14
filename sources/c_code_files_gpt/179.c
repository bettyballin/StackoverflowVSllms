#include <gcc-plugin.h>
#include <plugin-version.h>
#include <tree-pass.h>

// Assuming my_pass is defined elsewhere in the code
extern struct tree_pass my_pass;

int plugin_init(struct plugin_name_args *plugin_info, struct plugin_gcc_version *version)
{
    if (!plugin_default_version_check(version, &gcc_version))
    {
        return 1;
    }

    struct register_pass_info pass_info;
    pass_info.pass = &my_pass;
    pass_info.reference_pass_name = "cfg";
    pass_info.ref_pass_instance_number = 1;
    pass_info.pos_op = PASS_POS_INSERT_AFTER;

    register_callback(plugin_info->base_name, PLUGIN_PASS_MANAGER_SETUP, NULL, &pass_info);

    return 0;
}