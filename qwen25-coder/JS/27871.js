function updateScore(answer, correct, userId, score) {\n    var dataToSend = {\n        answer: answer,\n        correct: correct,\n        userId: userId,\n        score: score\n    };\n\n    if (answer == correct) {\n        $.post('updatescore.php', dataToSend, function(response) {\n            console.log("Server response: " + response);\n        });\n    }\n}