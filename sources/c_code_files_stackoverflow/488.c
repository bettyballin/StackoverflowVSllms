#include <stdio.h>
#include <curl/curl.h>

int main() {
    CURL *pCurlHandle = curl_easy_init();

    int offset = 0;
    int size = 10*1024;

    char range[256];
    curl_slist *pHeaders = NULL;
    snprintf(range, 256, "Range: bytes=%d-%d", offset, offset+size-1);

    pHeaders = curl_slist_append(pHeaders, range);
    curl_easy_setopt(pCurlHandle, CURLOPT_HTTPHEADER, pHeaders);

    curl_slist_free_all(pHeaders);
    pHeaders = NULL;

    curl_easy_cleanup(pCurlHandle);

    return 0;
}