function calculate_date() {\n  currentTime = new Date();\n  day         = currentTime.getDate() + 5;\n  year        = currentTime.getFullYear();\n  month       = currentTime.getMonth() + 1;\n  calcdate    = day + "/" + month + "/" + year;\n  return calcdate;\n}