function LandOnSpace(sender, args) {\n    // Assuming some condition based on your logic\n    if (!ShipAnimateActive && !blnWaitingOnServer) {\n        blnWaitingOnServer = true;\n        \n        // Simulate server communication or any other async operation\n        RunServerFunction("/sqgame/getJSLLandOnSpace");\n        ShowWaitingBox();\n        \n        // Invoke the JavaScript function with parameters\n        try {\n            HtmlPage.Window.Invoke("ShowMsg", 500, 700, "You owe us money");\n        } catch (e) {\n            console.error("Error invoking ShowMsg: ", e);\n        }\n    } else {\n        alert('Waiting on server.');\n    }\n}