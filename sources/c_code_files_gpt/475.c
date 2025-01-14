#include "httpd.h"
   #include "http_config.h"
   #include "http_protocol.h"
   #include "ap_config.h"

   static int example_handler(request_rec *r)
   {
       if (!r->handler || strcmp(r->handler, "example-handler")) {
           return DECLINED;
       }
       ap_set_content_type(r, "text/html");
       ap_rputs("Hello, world!", r);
       return OK;
   }

   static void example_register_hooks(apr_pool_t *p)
   {
       ap_hook_handler(example_handler, NULL, NULL, APR_HOOK_MIDDLE);
   }

   module AP_MODULE_DECLARE_DATA example_module = {
       STANDARD20_MODULE_STUFF,
       NULL,
       NULL,
       NULL,
       NULL,
       NULL,
       example_register_hooks
   };