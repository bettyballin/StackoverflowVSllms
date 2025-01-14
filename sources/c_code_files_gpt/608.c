#include <libguile.h>

void init_guile() {
    scm_init_guile();
}

SCM call_scheme_function(const char* function_name, SCM arg) {
    SCM func = scm_variable_ref(scm_c_lookup(function_name));
    return scm_call_1(func, arg);
}

int main() {
    // Initialize Guile
    init_guile();

    // Load the Scheme script
    scm_c_primitive_load("ai_behavior.scm");

    // Prepare argument for Scheme function
    SCM state = SCM_UNSPECIFIED;

    // Call Scheme function
    SCM result = call_scheme_function("calculate-next-move", state);

    // Process the result
    // ...

    return 0;
}