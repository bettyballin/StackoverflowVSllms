const form = document.getElementById('myForm');\nconst formData = new FormData(form);\n\nconst params = Array.from(formData.entries()).map(([key, value]) => ({ [key]: value }));\n\nsajax_do_call('funcName', params, 'callbackFuncName');