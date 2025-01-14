document.addEventListener("DOMContentLoaded", function() {\n    const textareas = document.querySelectorAll('textarea');\n\n    textareas.forEach(textarea => {\n        textarea.addEventListener('dragenter', handleDragEnter);\n        textarea.addEventListener('dragover', handleDragOver);\n        textarea.addEventListener('drop', handleDrop);\n    });\n\n    function handleDragEnter(event) {\n        event.preventDefault();\n        // Optionally, change border or style to indicate drag enter.\n    }\n\n    function handleDragOver(event) {\n        event.preventDefault(); // Necessary to allow drop\n        // You can change styles here as well if needed\n    }\n\n    function handleDrop(event) {\n        event.preventDefault();\n        const text = (event.dataTransfer.getData('text') || '').trim();\n        this.value = ''; // Clear the textarea\n        processText(text);\n    }\n\n    function processText(text) {\n        // Do something with the dropped text here...\n        console.log('Dropped text:', text);\n    }\n});