$('#questions-form ul li').each(function() {\n    // Find the closest fieldset ancestor of the current list item\n    var $closestFieldset = $(this).closest('fieldset');\n    \n    // Get the index of this fieldset among all fieldsets within the form\n    var qIndex = $('#questions-form fieldset').index($closestFieldset);\n    \n    console.log(qIndex);  // This will print the index of the fieldset relative to the form\n});