$('.block:has(div)').each(function() {\n    // Loop through each 'div' inside the current '.block'\n    $(this).find('div').each(function() {\n        // Do something with each item element\n        console.log($(this).attr('id')); // For example, log the id of each item\n    });\n});