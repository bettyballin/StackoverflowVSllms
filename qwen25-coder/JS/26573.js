function disableValidator() {\n       ValidatorEnable(document.getElementById('<%= RequiredFieldValidator1.ClientID %>'), false);\n       document.getElementById('<%= IsValidationDisabled.ClientID %>').value = 'true';\n   }