#include <curl/curl.h>

int main() {
    curl_global_init(CURL_GLOBAL_DEFAULT);
    CURL *curl;
    CURLcode res;
    curl = curl_easy_init();
    if(curl) {
        curl_easy_cleanup(curl);
    }
    curl_global_cleanup();
    return 0;
}