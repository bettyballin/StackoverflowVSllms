$(".answertextwrapper").click(function(event) {\n  var input = $(this).closest(".answers").find("input[type='radio']");\n  var questionId = input.attr('name');\n  var responseId = input.attr('value');\n  var answerText = displayPopupQuizAnswer(input);\n});