#include <stdio.h>
#include <string.h>
#include <curl/curl.h>

static const char *payload_text[] = {
  "To: recipient@example.com\r\n",
  "From: sender@example.com\r\n",
  "Subject: Test Email\r\n",
  "\r\n", /* empty line to divide headers from body, see RFC5322 */
  "This is a test email sent using libcurl.\r\n",
  NULL
};

struct upload_status {
  int lines_read;
};

static size_t payload_source(void *ptr, size_t size, size_t nmemb, void *userp) {
  struct upload_status *upload_ctx = (struct upload_status *)userp;
  const char *data;

  if ((size == 0) || (nmemb == 0) || ((size * nmemb) < 1)) {
    return 0;
  }

  data = payload_text[upload_ctx->lines_read];

  if (data) {
    size_t len = strlen(data);
    memcpy(ptr, data, len);
    upload_ctx->lines_read++;
    return len;
  }

  return 0;
}

int main(void) {
  CURL *curl;
  CURLcode res = CURLE_OK;
  struct curl_slist *recipients = NULL;
  struct upload_status upload_ctx;
  
  upload_ctx.lines_read = 0;

  curl_global_init(CURL_GLOBAL_DEFAULT); // Added this line to initialize libcurl
  curl = curl_easy_init();
  if (curl) {
    /* Set the URL for the SMTP server */
    curl_easy_setopt(curl, CURLOPT_URL, "smtp://smtp.example.com:25");

    /* Set the username and password if needed */
    curl_easy_setopt(curl, CURLOPT_USERNAME, "your_username");
    curl_easy_setopt(curl, CURLOPT_PASSWORD, "your_password");

    /* Set the sender */
    curl_easy_setopt(curl, CURLOPT_MAIL_FROM, "<sender@example.com>");

    /* Add recipients */
    recipients = curl_slist_append(recipients, "<recipient@example.com>");
    curl_easy_setopt(curl, CURLOPT_MAIL_RCPT, recipients);

    /* Specify the payload */
    curl_easy_setopt(curl, CURLOPT_READFUNCTION, payload_source);
    curl_easy_setopt(curl, CURLOPT_READDATA, &upload_ctx);
    curl_easy_setopt(curl, CURLOPT_UPLOAD, 1L);

    /* Send the message */
    res = curl_easy_perform(curl);

    /* Check for errors */
    if (res != CURLE_OK) {
      fprintf(stderr, "curl_easy_perform() failed: %s\n", curl_easy_strerror(res));
    }

    /* Clean up */
    curl_slist_free_all(recipients);
    curl_easy_cleanup(curl);
  }

  curl_global_cleanup(); // Added this line to clean up libcurl
  return (int)res;
}