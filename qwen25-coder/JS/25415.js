$(document).ready(function() {\n    $('form').on('submit', function(event) {\n        var $form = $(this);\n        // Hide all submit buttons, then re-enable them after submission\n        $form.find(':submit').prop('disabled', true);\n\n        // Create a hidden input to store which button was pressed\n        var $submitButton = $(event.originalEvent.explicitOriginalTarget || event.originalEvent.originalTarget.value);\n        if ($submitButton.length > 0) {\n            $('<input />')\n                .attr('type', 'hidden')\n                .attr('name', $submitButton.attr('name'))\n                .attr('value', $submitButton.val())\n                .appendTo($form);\n        }\n\n        // Re-enable the submit buttons\n    });\n});