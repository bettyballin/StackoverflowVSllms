$(document).ready(function () {\n  // Handle Form-Submission\n  $("#mainForm").submit(function (event) {\n    // Prevent the default form submission\n    event.preventDefault();\n\n    // Reset Error Array\n    let errors = [];\n\n    /* Validation Code Removed - Not Relevant */\n\n    // Check if errors exist\n    if (errors.length > 0) {\n      return false;\n    } else {\n      $("div.errors").html("");\n      $.post("post.php", {\n        "First Name": $("#name_first").val(),\n        "Last Name": $("#name_last").val(),\n        "Home State": $("#home_state").val(),\n        "Primary Email": $("#email_primary").val()\n      }).done(function() {\n        // Submit the form after the post is done\n        $("#mainForm")[0].submit();\n      }).fail(function() {\n        // Handle the failure case\n        alert("There was an error processing your request.");\n      });\n    }\n  });\n});