// Get the user's preferred language\nconst userLanguage = navigator.language || navigator.userLanguage;\nconsole.log('User language: ' + userLanguage);\n\n// Get the user's list of preferred languages\nconst userLanguages = navigator.languages;\nconsole.log('User preferred languages: ' + userLanguages.join(', '));