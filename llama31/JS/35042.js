var answers = {};\nfor (x = 0; x < allAnswers.length; x++) {\n    answers[x] = {\n        'id': allAnswers[x]['id'],\n        'val': $("#field_" + x).val()\n    };\n}\n\nvar data = {\n    'id': questions[qId]['id'],\n    'answers': JSON.stringify(answers)\n};\n\n$.post('index.php', data);