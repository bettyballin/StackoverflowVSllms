// First Ajax request\n$(document).queue("ajaxRequests", function() {\n  $.ajax({\n    // Stuff\n    success: function() {\n      $(document).dequeue("myName");\n    });\n  });\n});\n\n// Second Ajax request\n$(document).queue("ajaxRequests", function() {\n  $.ajax({\n    // Stuff\n    success: function() {\n      $(document).dequeue("myName");\n    });\n  });\n});\n\n// Trigger the queue\n$(document).dequeue("ajaxRequests");