#include <stdio.h>
#include "lrun.h"
#include "lr.h"
#include "lrd.h"

int main() {
    web_add_header("User-Agent", "LoadRunner/12.5");  // Customize header
    lr_think_time(5);                                 // Add random think time
    web_custom_request("Request_URL/SessionID",       // Use appropriate session ID request URL
                       "Method=POST", "EncType=text/html",  
                       "BodyFileName={tempDir}body.txt") {
        web_add_header("X-Custom-Header", lr_eval_string(
                "TestRun_{{loadrunnerScriptId}}"));  // XHTTP header with variable value per VUser session
    };
    return 0;
}