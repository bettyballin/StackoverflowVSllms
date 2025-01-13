$(document).ready(function () {\n  // Handle Form-Submission\n  $("#mainForm").submit(function (event) {\n    // Prevent default form submission behavior\n    event.preventDefault();\n\n    // Reset Error Array\n    errors = new Array();\n\n    /* Validation Code Removed - Not Relevant */\n\n    // Check if errors exist\n    if (errors.length > 0) {\n      return;\n    } else {\n      $("div.errors").html("");\n      $.post("post.php", {\n        "First Name": name_first.val(),\n        "Last Name": name_last.val(),\n        "Home State": home_state.val(),\n        "Primary Email": email_primary.val()\n      }).done(function () {\n        // Manually submit the form after the $.post request has completed\n        $("#mainForm")[0].submit();\n      });\n    }\n  });\n});