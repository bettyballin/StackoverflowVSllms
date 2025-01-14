// Create an instance of PageRequestManager\nvar prm = Sys.WebForms.PageRequestManager.getInstance();\n\nprm.add_endRequest(function(sender, args) {\n    // Get the updated panels\n    var updatedPanelIDs = args.get_updatedPanels();\n\n    // Iterate through each updated panel ID\n    for (var i = 0; i < updatedPanelIDs.length; i++) {\n        if(updatedPanelIDs[i].get_element().id === 'YourUpdatePanelClientID') {\n            // Call your specific function here\n            YourCustomFunction();\n            break;\n        }\n    }\n});\n\nfunction YourCustomFunction() {\n    // Your script here\n    alert('Specific UpdatePanel has been updated!');\n}