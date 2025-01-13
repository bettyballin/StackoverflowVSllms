function generateQuestion(i) {\n       $.get('quiz.xml', function(d) {\n           var $questions = $(d).find('question');\n           if (i < $questions.length) {\n               var $question = $questions.eq(i);\n               var questionContent = $question.attr('content');\n               $('#quizQuestion').html(questionContent);\n\n               var answersHtml = '';\n               $question.find('answer').each(function() {\n                   var answerText = $(this).text();\n                   answersHtml += '<div><input type="radio" name="answer" value="' + answerText + '"> ' + answerText + '</div>';\n               });\n               $('#quizAnswers').html(answersHtml);\n\n               $('#continueButton').off('click').on('click', function() {\n                   var selectedAnswer = $('input[name="answer"]:checked').val();\n                   if (selectedAnswer) {\n                       alert('You selected: ' + selectedAnswer);\n                       generateQuestion(i + 1);\n                   } else {\n                       alert('Please select an answer.');\n                   }\n               });\n           } else {\n               $('#quizQuestion').html('Quiz completed!');\n               $('#quizAnswers').html('');\n               $('#continueButton').hide();\n           }\n       });\n   }\n\n   $(document).ready(function() {\n       generateQuestion(0);\n   });