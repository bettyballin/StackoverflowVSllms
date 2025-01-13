// Attach click event to each table cell\n$('table td').on('click', function() {\n  // Get the clicked cell's contents\n  var cellContents = $(this).html();\n  \n  // Create a modal window with a textarea\n  var modal = $('<div id="editor-modal" style="display:none;">' +\n               '<textarea id="editor-textarea">' + cellContents + '</textarea>' +\n               '<button id="save-changes">Save Changes</button>' +\n               '</div>');\n  \n  // Display the modal window\n  modal.appendTo('body').fadeIn();\n  \n  // Attach click event to the save button\n  $('#save-changes').on('click', function() {\n    // Get the edited contents from the textarea\n    var newContents = $('#editor-textarea').val();\n    \n    // Update the original cell's contents\n    $(this).closest('td').html(newContents);\n    \n    // Hide the modal window\n    modal.fadeOut().remove();\n  });\n});