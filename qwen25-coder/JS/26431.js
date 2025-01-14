// Function to perform AJAX request and update content\nfunction loadPage(pageNumber) {\n    // Perform your AJAX call, assuming jQuery here for simplicity\n    $.ajax({\n        url: 'your-server-endpoint',\n        data: { page: pageNumber },\n        success: function(data) {\n            // Update the content with new data from server\n            $('#content').html(data);\n\n            // Use History API to update URL\n            window.history.pushState({page: pageNumber}, '', `www.example.com/p:${pageNumber}/`);\n        }\n    });\n}\n\n// Event listener for back/forward navigation\nwindow.addEventListener('popstate', function(event) {\n    if (event.state) {\n        loadPage(event.state.page);\n    }\n});\n\n// Example usage of the function to load page 3\nloadPage(3);