#include <windows.h>\n#include <powrprof.h>\n\nvoid HibernateSystem() {\n    // The first parameter indicates if the system should hibernate.\n    // The second and third parameters control whether a user is logged on and whether critical state is ignored.\n    SetSuspendState(TRUE, TRUE, FALSE);\n}\n\nvoid SleepSystem() {\n    // The first parameter indicates if the system should hibernate (FALSE for sleep).\n    SetSuspendState(FALSE, TRUE, FALSE);\n}