function myAlert(){\n    alert('magic!!!');\n}\n\nif(document.addEventListener){   \n    myForm.addEventListener('submit', myAlert(), false); \n}else{   \n    myForm.attachEvent('onsubmit', myAlert()); \n}