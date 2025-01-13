#include <occi.h>\n\nusing namespace oracle::occi;\n\nint main() {\n    // Create the OCCI environment\n    Environment* env = Environment::createEnvironment(Environment::DEFAULT);\n    \n    // Your database interaction code goes here\n    \n    // Terminate the OCCI environment\n    Environment::terminateEnvironment(env);\n    \n    return 0;\n}