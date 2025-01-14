function PleaseWaitShow() {\n    try {\n        var isPageValid = true;\n\n        // Check if client-side validation is active and call Page_ClientValidate()\n        if (typeof(Page_ClientValidate) === 'function') {\n            isPageValid = Page_ClientValidate();\n        } else {\n            console.log("Page_ClientValidate function not available, assuming page is valid.");\n        }\n\n        if (isPageValid) {\n            // Hide submit buttons\n            document.getElementById('pnlSubmitButton').style.display = 'none';\n\n            // Show please wait panel\n            document.getElementById('pnlPleaseWait').style.display = 'block';\n        } else {\n            console.log("Page validation failed; do not proceed.");\n        }\n    } catch (er) {\n        console.error("Error in PleaseWaitShow(): ", er);\n    }\n}