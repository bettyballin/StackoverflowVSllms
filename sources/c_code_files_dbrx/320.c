#include <windows.h>
#include <wlanapi.h>
#include <stdio.h>

int main() {
    DWORD get_wireless_networks() {
        HANDLE client = NULL;
        DWORD negotiatedVersion;
        PWLAN_INTERFACE_INFO_LIST ifList = NULL;
        DWORD dwRetVal = NO_ERROR;
        DWORD dwReasonCode = 0; // Define dwReasonCode
        DOT11_SSID dot11Ssid; // Define dot11Ssid
        DOT11_BSS_TYPE dot11ScanType; // Define dot11ScanType
        DOT11_MAC_ADDRESS dot11BSSID; // Define dot11BSSID
        DOT11_NETWORK *buf; // Define buf
        int number_of_networks = 0; // Define number_of_networks

        if ((dwRetVal = WlanOpenHandle(1, NULL, &negotiatedVersion, &client)) != ERROR_SUCCESS) {
            printf("Cannot open the handle.");
            return dwRetVal; /* failure */
        }

        while (!ifList || !dwReasonCode) { // wait ifList updated
            if ((dwRetVal = WlanGetNetworkBssList(client, &ifList, NULL, NULL, &dot11Ssid, dot11ScanType, dot11BSSID)) != ERROR_SUCCESS) {
                break;
            }
        }

        wprintf(L"%d networks available:\n", number_of_networks);
        while (ifList) { // print all ssid in network
            buf = (DOT11_NETWORK *)ifList->Networks;
            printf("\tSSID : %ws\n", buf->dot11Ssid.ucSSID);
            ifList = ifList->pNext;
        }

        if (dwRetVal == ERROR_INVALID_PASSWORD || dwRetVal == ERROR_ACCESS_DENIED) { // handle errors
            wprintf(L"Error (Security related) ...\n");
        }

        return dwRetVal;
    }

    return get_wireless_networks();
}