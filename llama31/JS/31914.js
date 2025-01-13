function translateText(text, languages) {\n  return languages.reduce((promise, lang, index) => {\n    return promise.then((previousText) => {\n      return new Promise((resolve, reject) => {\n        google.language.translate(previousText, lang, lang, function(result) {\n          if (result.translation) {\n            resolve(result.translation);\n          } else {\n            reject(new Error('Translation failed'));\n          }\n        });\n      });\n    });\n  }, Promise.resolve(text));\n}\n\ntranslateText(testua, languages).then((finalText) => {\n  f.textarea1.value = finalText;\n});