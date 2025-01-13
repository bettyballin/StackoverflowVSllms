#include "httpd.h"\n   #include "http_config.h"\n   #include "http_protocol.h"\n   #include "ap_config.h"\n\n   static int example_handler(request_rec *r)\n   {\n       if (!r->handler || strcmp(r->handler, "example-handler")) {\n           return DECLINED;\n       }\n       ap_set_content_type(r, "text/html");\n       ap_rputs("Hello, world!", r);\n       return OK;\n   }\n\n   static void example_register_hooks(apr_pool_t *p)\n   {\n       ap_hook_handler(example_handler, NULL, NULL, APR_HOOK_MIDDLE);\n   }\n\n   module AP_MODULE_DECLARE_DATA example_module = {\n       STANDARD20_MODULE_STUFF,\n       NULL,\n       NULL,\n       NULL,\n       NULL,\n       NULL,\n       example_register_hooks\n   };