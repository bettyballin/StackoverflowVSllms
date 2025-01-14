/* Includes */
#include <windows.h>
#include <smsapi.h>
#include <ctype.h>
#include <stdio.h>
#include <objbase.h> // For CoCreateInstance and CoUninitialize

/* Function prototypes */
int main(int argc, char* argv[]);

void ShowResultStatus(DWORD dwError);
void SendSMSAndGetReport(CHAR *lpszNumber, CHAR *lpszMessage);

/* Main function */
int main(int argc, char* argv[]) {
    if (argc < 3) {
        printf("Usage: ");
        printf("%s phone-number sms-message", argv[0]);
        return 1;
    }

    CoInitialize(NULL); // Initialize the COM library
    SendSMSAndGetReport(argv[1], argv[2]);
    return 0;
}

void ShowResultStatus(DWORD dwError){
  switch (dwError) {
	case S_OK:
      printf("\n\tSuccess. SMS sent successfully and report received.");
      break;
    case E_INVALIDARG:
        printf("\nError - Invalid Argument.");
        break;
    default:
         printf("Unrecognized Error %ul",dwError);
  }
}

void SendSMSAndGetReport(CHAR *lpszNumber, CHAR *lpszMessage){
    LPSMSSendMessage smsSendMsg; /* For sending Sms */
    SMSSendStatus sendStatus; /* Send Status */
	LPSMSMessage smsMessage = NULL; /* The returned report/SMS message object */

	/* Allocate memory for the new instance of the SMS_SENDMESSAGE class*/
	CoCreateInstance(CLSID_SmsSendMessage, NULL, CLSCTX_ALL, IID_ISMSSendMessage, (LPVOID *)&smsSendMsg);

    /* Set destination phone number */
   smsSendMsg->put_PhoneNumber(lpszNumber);
    /* Set SMS message to send*/
	if(lpszMessage == NULL) {
        smsSendMsg = NULL;
           return;
      } else
          smsSendMsg->put_Body(lpszMessage); // Removed the dereference operator (*)

   HRESULT hr = 0;

   // Send message
    printf("\nSending SMS...");
	hr = smsSendMsg->SendMessage(VARIANT_FALSE, &sendStatus); /* Send the SMS */
	ShowResultStatus(hr);
	if (SUCCEEDED(hr)) {
        hr = sendStatus.hr;
      } else {
           printf("\nMessage could not be sent.");
          return;
        }
       ShowResultStatus(sendStatus.hr); /* Print status result */

    // Get Sms from the message database to get report
    LPSMSMessage *pSmsList = NULL;  	/* Pointer to List of received messages*/
  HRESULT hr2 = smsSendMsg->GetMessages(NULL, &pSmsList); /* Get all the sent SMS */

    if (hr2 == S_OK) {
         printf("\nReport :");
       for (long i = (*pSmsList)->Count - 1; i >= 0 ; --i){
	     smsMessage = (*pSmsList)->Item[i]; /* Get individual message from list */
             ShowResultStatus(smsMessage->Acknowledgment);
         }
      FreeSMSMessage(*pSmsList); /* free the msg object */
    } else {
       printf("Could not get report"); // Unable to acquire Report.
     }
CoUninitialize();	/* Release resources used by COM library*/
}