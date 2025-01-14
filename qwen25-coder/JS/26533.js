$(".RadioButton, label[for], .answertextwrapper").click(function(event) {\n    var radioButton;\n    \n    // Determine if the clicked element is a label or wrapper, and find the input within\n    if ($(this).is('label') || $(this).is('.answertextwrapper')) {\n        radioButton = $(this).find('.RadioButton');\n    } else {\n        radioButton = $(this);\n    }\n\n    var questionId = radioButton.attr('name');\n    var responseId = radioButton.val();\n    var answerText = displayPopupQuizAnswer(radioButton);\n\n    // Optionally, trigger the click on the radio button to ensure it is checked\n    radioButton.prop("checked", true).trigger("change");\n});