var usernameok;\nvar emailok;\n\nfunction checksubmit() {\n  if (usernameok && emailok) {\n    document.getElementById("button").disabled = false;\n  } else {\n    document.getElementById("button").disabled = true;\n  }\n}\n\nfunction username(username) {\n  make_request();\n\n  function stateck() {\n    if (httpxml.readyState == 4) {\n      if (httpxml.responseText.indexOf("Username Ok") >= 0) {\n        usernameok = true;\n      } else {\n        usernameok = false;\n        document.getElementById("error_div").innerHTML = httpxml.responseText;\n        document.getElementById("error_div").style.display = "block";\n      }\n      checksubmit();\n    }\n  }\n\n  httpxml.onreadystatechange = stateck;\n  user_url = "check_username.php?username=" + username.value;\n  httpxml.open("GET", user_url, true);\n  httpxml.send(null);\n}\n\nfunction email(email) {\n  make_request();\n\n  function stateck() {\n    if (httpxml.readyState == 4) {\n      if (httpxml.responseText.indexOf("Email Ok") >= 0) {\n        emailok = true;\n      } else {\n        emailok = false;\n        document.getElementById("error_div").innerHTML = httpxml.responseText;\n        document.getElementById("error_div").style.display = "block";\n      }\n      checksubmit();\n    }\n  }\n\n  httpxml.onreadystatechange = stateck;\n  email_url = "check_email.php?email=" + email.value;\n  httpxml.open("GET", email_url, true);\n  httpxml.send(null);\n}