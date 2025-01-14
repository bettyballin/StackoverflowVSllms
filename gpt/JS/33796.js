let unsavedChanges = false;\n\n// Example function to set unsaved changes\nfunction setUnsavedChanges(status) {\n    unsavedChanges = status;\n}\n\n// Check for unsaved changes before unloading\nwindow.onbeforeunload = function(event) {\n    if (unsavedChanges) {\n        event.preventDefault();\n        event.returnValue = '';\n        showModal();\n        return '';\n    }\n};\n\nfunction showModal() {\n    let modal = document.getElementById('saveModal');\n    modal.style.display = 'block';\n\n    document.getElementById('saveButton').onclick = function() {\n        // Implement save functionality\n        unsavedChanges = false;\n        modal.style.display = 'none';\n        window.location.href = 'your-next-page.html'; // Redirect to the next page\n    };\n\n    document.getElementById('discardButton').onclick = function() {\n        unsavedChanges = false;\n        modal.style.display = 'none';\n        window.location.href = 'your-next-page.html'; // Redirect to the next page\n    };\n}