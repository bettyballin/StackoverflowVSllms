#include <windows.h>\n#include "obj.h"\n#include <GL/gl.h>\n\nint main() {\n    GLuint objectList;\n    GLboolean result = load_obj("path_to_file.obj", &objectList);\n\n    if (result) {\n        // Handle success\n    } else {\n        // Handle failure\n    }\n\n    return 0;\n}