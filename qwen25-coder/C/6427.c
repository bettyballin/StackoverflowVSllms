// Example of using libuv to perform a simple file read asynchronously\n#include <stdio.h>\n#include <stdlib.h>\n#include <uv.h>\n\nvoid read_callback(uv_fs_t *req) {\n    if (req->result >= 0) {\n        printf("File read successfully, contents:\n%.*s", (int) req->result,\n               (char *) req->ptr);\n    } else {\n        fprintf(stderr, "Error reading file: %s\n",\n                uv_strerror(req->result));\n    }\n    uv_fs_req_cleanup(req);\n}\n\nint main() {\n    uv_loop_t *loop = uv_default_loop();\n    uv_fs_t open_req;\n\n    uv_fs_open(loop, &open_req, "/path/to/file",\n               O_RDONLY, 0644, NULL);\n\n    if (open_req.result >= 0) {\n        uv_file file = open_req.result;\n        uv_buf_t buffer = uv_buf_init(malloc(128), 128);\n        uv_fs_read(loop, &open_req,\n                   file, &buffer, 1, -1,\n                   read_callback);\n        uv_fs_req_cleanup(&open_req);\n    } else {\n        fprintf(stderr, "Cannot open file: %s\n",\n                uv_strerror(open_req.result));\n        uv_run(loop, UV_RUN_DEFAULT);\n        return 1;\n    }\n\n    uv_run(loop, UV_RUN_DEFAULT);\n\n    printf("Done...\n");\n    free(buffer.base);\n\n    return 0;\n}