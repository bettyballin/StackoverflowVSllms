#include "soapH.h"
#include "service.nsmap"
#include <stdio.h>
#include <stdlib.h>

int main() {
    struct soap soap;
    struct _ns__yourMethodRequest request; // Assuming this is your request struct
    struct _ns__yourMethodResponse response; // Assuming this is your response struct

    soap_ssl_init(); // Initialize OpenSSL

    soap_init(&soap);
    if (soap_ssl_client_context(&soap,
                                SOAP_SSL_NO_AUTHENTICATION, // No server authentication
                                NULL,  // Key file (optional)
                                NULL,  // Password for key file (optional)
                                "cacert.pem", // Trusted CA file
                                NULL,  // Optional: Random seed file
                                NULL   // Optional: Diffie-Hellman parameters file
                                )) {
        soap_print_fault(&soap, stderr);
        exit(1);
    }

    // Initialize request (example)
    request.input = "Hello, World!";

    // Call your web service method here
    if (soap_call_ns__yourMethod(&soap, "https://yourserver.com/service", NULL, &request, &response)) {
        soap_print_fault(&soap, stderr);
    } else {
        // Process response
        printf("Response: %s\n", response.output);
    }

    soap_destroy(&soap);
    soap_end(&soap);
    soap_done(&soap);
    return 0;
}