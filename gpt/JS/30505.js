document.addEventListener("turbolinks:load", function() {\n  var countrySelect = document.getElementById('country_select');\n  if (countrySelect) {\n    countrySelect.addEventListener('change', function() {\n      var country = countrySelect.value;\n      var xhr = new XMLHttpRequest();\n      xhr.open('GET', '/update_states?country=' + encodeURIComponent(country), true);\n      xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');\n      xhr.onreadystatechange = function() {\n        if (xhr.readyState == 4 && xhr.status == 200) {\n          document.getElementById('states_div').innerHTML = xhr.responseText;\n        }\n      };\n      xhr.send();\n    });\n  }\n});