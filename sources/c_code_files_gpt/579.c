#include <windows.h>
#include <wincrypt.h>
#include <schannel.h>
#include <stdio.h>  // Add this line for printf
#include <stdlib.h>  // Add this line for malloc and free

SECURITY_STATUS InitializeSchannel(PCredHandle phCreds, CtxtHandle *phContext, BOOL fClient, PBYTE pbSessionID, DWORD cbSessionID) {
    // Initialize security package
    SecPkgContext_SessionKey sessionKey;
    SECURITY_STATUS ss = SEC_E_OK;
    
    // Create the security credentials
    SCHANNEL_CRED schannelCred = { 0 };
    schannelCred.dwVersion = SCHANNEL_CRED_VERSION;
    schannelCred.grbitEnabledProtocols = SP_PROT_TLS1_2; // Use the desired protocol
    
    // Acquire the credentials handle
    ss = AcquireCredentialsHandle(NULL, UNISP_NAME, fClient ? SECPKG_CRED_OUTBOUND : SECPKG_CRED_INBOUND, NULL, &schannelCred, NULL, NULL, phCreds, NULL);
    if (ss != SEC_E_OK) {
        return ss;
    }
    
    // Initialize security context
    SecBufferDesc OutBuffer, InBuffer;
    SecBuffer OutBuffers[1], InBuffers[1];
    DWORD dwSSPIFlags, dwSSPIOutFlags;

    OutBuffers[0].pvBuffer = NULL;
    OutBuffers[0].BufferType = SECBUFFER_TOKEN;
    OutBuffers[0].cbBuffer = 0;

    OutBuffer.cBuffers = 1;
    OutBuffer.pBuffers = OutBuffers;
    OutBuffer.ulVersion = SECBUFFER_VERSION;

    InBuffers[0].pvBuffer = pbSessionID;
    InBuffers[0].cbBuffer = cbSessionID;
    InBuffers[0].BufferType = SECBUFFER_TOKEN;

    InBuffer.cBuffers = 1;
    InBuffer.pBuffers = InBuffers;
    InBuffer.ulVersion = SECBUFFER_VERSION;

    dwSSPIFlags = ISC_REQ_SEQUENCE_DETECT | ISC_REQ_REPLAY_DETECT |
                  ISC_REQ_CONFIDENTIALITY | ISC_RET_EXTENDED_ERROR |
                  ISC_REQ_ALLOCATE_MEMORY | ISC_REQ_STREAM;

    ss = InitializeSecurityContext(phCreds, NULL, NULL, dwSSPIFlags, 0, SECURITY_NATIVE_DREP, &InBuffer, 0, phContext, &OutBuffer, &dwSSPIOutFlags, NULL);
    
    if (ss == SEC_I_CONTINUE_NEEDED || ss == SEC_E_OK) {
        // Save the session ID for reuse
        QueryContextAttributes(phContext, SECPKG_ATTR_SESSION_KEY, &sessionKey);
        pbSessionID = (PBYTE)malloc(sessionKey.SessionKeyLength);
        memcpy(pbSessionID, sessionKey.SessionKey, sessionKey.SessionKeyLength);
        cbSessionID = sessionKey.SessionKeyLength;
    }
    
    return ss;
}

int main() {
    CredHandle hClientCreds;
    CtxtHandle hClientContext;
    BYTE *pbSessionID = NULL;
    DWORD cbSessionID = 0;

    SECURITY_STATUS ss = InitializeSchannel(&hClientCreds, &hClientContext, TRUE, pbSessionID, cbSessionID);
    if (ss != SEC_E_OK) {
        printf("Failed to initialize Schannel: 0x%x\n", ss);
        return 1;
    }

    // Use the session ID to reconnect without renegotiation
    ss = InitializeSchannel(&hClientCreds, &hClientContext, TRUE, pbSessionID, cbSessionID);
    if (ss != SEC_E_OK) {
        printf("Failed to reuse Schannel session: 0x%x\n", ss);
        return 1;
    }

    // Clean up
    FreeCredentialsHandle(&hClientCreds);
    DeleteSecurityContext(&hClientContext);
    if (pbSessionID) free(pbSessionID);

    return 0;
}