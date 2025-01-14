#include "gcc-plugin.h"
#include "plugin-version.h"
#include "tree.h"
#include "tree-pass.h"

int plugin_is_GPL_compatible;

static unsigned int my_pass_exec(void)
{
    // Your custom pass logic here
    return 0;
}

static struct opt_pass my_pass = {
    .type = GIMPLE_PASS,
    .name = "my_pass",
    .gate = NULL,
    .execute = my_pass_exec,
    .sub = NULL,
    .next = NULL,
    .static_pass_number = 0,
    .tv_id = TV_NONE,
    .properties_required = 0,
    .properties_provided = 0,
    .properties_destroyed = 0,
    .todo_flags_start = 0,
    .todo_flags_finish = 0
};

int plugin_init(struct plugin_name_args *plugin_info,
                struct plugin_gcc_version *version)
{
    struct register_pass_info pass_info;

    pass_info.pass = &my_pass;
    pass_info.reference_pass_name = "ssa";
    pass_info.ref_pass_instance_number = 1;
    pass_info.pos_op = PASS_POS_INSERT_AFTER;

    register_callback(plugin_info->base_name, PLUGIN_PASS_MANAGER_SETUP, NULL, &pass_info);

    return 0;
}