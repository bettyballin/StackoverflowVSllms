$(document).ready(function() {\n    $("#user_name").blur(function() {\n        if ($(this).val().length > 4) {\n            $("#usernamecheckbox").html("<img src='images/checkmark.png' alt='' />");\n        } else {\n            $("#usernamecheckbox").html("<img src='images/xmark.png' alt='' />");\n        }\n    });\n    $("#pass").blur(function() {\n        if ($(this).val().length < 4) {\n            $("#passwordcheckbox").html("<img src='images/xmark.png' alt='' />"); // Changed passcheckbox to passwordcheckbox\n        } else {\n            $("#passwordcheckbox").html("<img src='images/checkmark.png' alt='' />"); // Added missing else clause for consistency\n        }\n    });\n    $("#confirmpass").blur(function() {\n        if ($(this).val() != $("#pass").val()){\n            $("#passwordcheckbox").html("<img src='images/xmark.png' alt='' />");\n        } else {\n            $("#passwordcheckbox").html("<img src='images/checkmark.png' alt='' />");\n        }\n    });\n});