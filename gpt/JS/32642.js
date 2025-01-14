// Assuming the pager is inside a container with id "pagerContainer"\ndocument.getElementById('pagerContainer').addEventListener('click', function(event) {\n    // Check if the clicked element is a pager link\n    if (event.target && event.target.matches('.pager-link')) {\n        event.preventDefault();\n        \n        // Your AJAX call to retrieve the next set of data\n        // Example: loadNextPage(event.target.dataset.page);\n\n        // Example function to handle your AJAX call and update the table and pager\n        function loadNextPage(pageNumber) {\n            // Perform your AJAX call here\n            // On success, update the table and pager HTML\n            // Example:\n            // document.getElementById('tableContainer').innerHTML = newTableHtml;\n            // document.getElementById('pagerContainer').innerHTML = newPagerHtml;\n        }\n\n        // Call the function to load the next page\n        loadNextPage(event.target.dataset.page);\n    }\n});