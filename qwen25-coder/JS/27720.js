function triggerDeleteEventWithValue(value) {\n    // Set the value of the hidden field\n    document.getElementById('<%= hiddenData.ClientID %>').value = value;\n    \n    // Trigger the link button click event for postback\n    document.getElementById('<%= lnkTriggerPostback.ClientID %>').click();\n}