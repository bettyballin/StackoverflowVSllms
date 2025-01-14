#include <esmtp/esmtp.h>

int main() {
    esmtp_mail mail; /* create an empty mail structure */
    esmtp_error error = ESMPT_ERROR(0); /* clear error code storage variable */

    /* setup mail details - these can be set directly to desired values or loaded from rc file */
    esmtp_set_rcpt(&mail, "recipient@example.com");                                  // recipient email address
    esmtp_set_from(&mail, "sender@example.com (Sender Name)");          // sender's name and email address
    esmtp_set_subject(&mail, ESMPT_ARG("Subject: The subject of your mail")); // the mail's subject line
    esmtp_set_message(&mail, "<html><body>This is a <b>test</b></body></html>", "text/html");  // the body (HTML version) of this email. You can provide plain text as well if needed
    esmtp_load_rc(esmtp_check_rcfile(), &mail, FALSE, &error);            /* load other attributes from rc file */

    const char* smtpServerAddress = "smtpserver.example.com";          // provide SMTP server's address
	const int smtpPortNumber = 25;                             // and port number

    esmtp_open(&mail, smtpServerAddress , smtpPortNumber);           /* open connection to SMTP server */
    esmtp_send(&mail, FALSE, &error);                            /* send email! (synchronous) */

    esmtp_close(&mail);  // Close the SMTP connection
    esmtp_destroy(&mail);  // Free the mail structure

    return 0;
}