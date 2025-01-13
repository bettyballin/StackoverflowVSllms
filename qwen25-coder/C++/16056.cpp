#include <msvid.h>\n#include <msvapi.h>\n\nvoid AddMessageToInboxL(const TMsvId& aParentEntry, HBufC16* aBodyText, const TDes8* aSmsPdu)\n{\n    CMsvSession* msvSession = CMsvSession::OpenL(Session());\n    CleanupStack::PushL(msvSession);\n\n    // Get entry root\n    CMsvEntrySelection entries;\n    CleanupClosePushL(CMsvRootEntry::NewL(*msvSession, TMsvSelectionOrdering()));\n\n    entries.AppendL(KMsvGlobalInBoxIndexEntryId);\n    \n    CMsvEntry* parentEntry = CMsvEntry::NewL(*msvSession, *entries[0]);\n    CleanupStack::PushL(parentEntry);\n\n    // Create a new entry in the selected folder (e.g., Inbox)\n    CMsvStore* store = msvSession->GetStoreL();\n    CleanupClosePushL(store);\n    \n    TMsvId serverUid(KUidMsgTypeSMS);  // Server UID for SMS\n    TMsvEntry entry;\n    entry.iDate.HomeTime();            // Set current time as message date\n\n    // Create a new entry id for the message\n    CMsvEntry* msgEntry = CMsvEntry::NewL(*store, entries[0]->EntryId(), entry);\n    CleanupStack::PushL(msgEntry);\n\n    // Write SMS PDU data to the entry stream\n    HBufC8* body = HBufC8::Alloc(aSmsPdu->Size());\n    TPtr8 buffer(body->Des());\n    buffer.Copy(*aSmsPdu);\n\n    TMsvPartList parts;\n    msgEntry->RestoreL(parts, iStatus);\n    SetActive();\n    User::WaitForRequest(iStatus); \n\n    // Create new body part entry\n    CMsvEntrySelection* selections = msgEntry->ChildrenWithMtmL(KUidMsgTypeSMS);\n    CleanupStack::PushL(selections);\n\n    if (selections->Count() > 0)\n    {\n        CMsvEntry& bodyPart = msvSession->GetEntryL((*selections)[0]);\n        bodyPart.SetBodyTextL(*aBodyText);\n    }\n\n    // Notify that the entry has been updated.\n    msgEntry->NotifyEntryChangeEventL(EFalse, TTimeIntervalSeconds(2));\n\n    CleanupStack::PopAndDestroy(5);  // body, msgEntry, selections, parentEntry, store\n}\n\n// Example usage:\nHBufC16* smsText = HBufC16::NewLC(_L("Your SMS text goes here"));\nTBuf8<100> smsPdu;\nsmsPdu.Copy(_L8("Here you would put the PDU data of the received SMS"));\n\nTMsvId inboxFolder(KMsvGlobalInBoxIndexEntryId);\nAddMessageToInboxL(inboxFolder, smsText, &smsPdu);\n\nCleanupStack::PopAndDestroy(2); // smsPdu, smsText