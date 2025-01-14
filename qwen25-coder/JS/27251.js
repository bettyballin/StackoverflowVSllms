var popup = window.open('', '_blank');\npopup.location = "new-page.html";\n\n// Function to check if the page is loaded and then call do_something\nfunction checkPopupLoad() {\n    try {\n        // Check if the document and body are fully loaded\n        if (popup.document.readyState === 'complete') {\n            do_something();\n        } else {\n            setTimeout(checkPopupLoad, 100); // Check again in 100ms\n        }\n    } catch(e) {\n        // Catch any security exceptions that occur when trying to access the popup's document\n        setTimeout(checkPopupLoad, 100);\n    }\n}\n\n// Start checking if the page is loaded\ncheckPopupLoad();