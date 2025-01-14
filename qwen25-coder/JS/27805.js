$(document).ready(function() {\n    // Function to show a specific form and hide others\n    function showForm(formId) {\n        $('#form1, #form2, #form3').hide(); // Hide all forms\n        $('#' + formId).show(); // Show the specified form\n    }\n\n    // Event handlers for links to switch forms\n    $('a[href=""]').on('click', function(e) {\n        e.preventDefault(); // Prevent default link behavior\n        if ($(this).text() === 'form1') {\n            showForm('form1');\n        } else if ($(this).text() === 'form2') {\n            showForm('form2');\n        } else if ($(this).text() === 'form3') {\n            showForm('form3');\n        }\n    });\n\n    // Event handler to handle Enter key press\n    $(document).on('keydown', function(event) {\n        if (event.key === "Enter") {\n            // Find the currently visible form and submit it\n            var $visibleForm = $('form:visible');\n            if ($visibleForm.length) {\n                $visibleForm.submit();\n            }\n        }\n    });\n});