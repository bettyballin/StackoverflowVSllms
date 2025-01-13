//@param timestamp An ISO-8601 timestamp in the form YYYY-MM-DDTHH:MM:SS±HH:MM\n//Note: Some other valid ISO-8601 timestamps are not accepted by this function\nfunction parseISO8601(timestamp)\n{\n  var regex = new RegExp("^([\\d]{4})-([\\d]{2})-([\\d]{2})T([\\d]{2}):([\\d]{2}):([\\d]{2})([\\+\\-])([\\d]{2}):([\\d]{2})$");\n  var matches = regex.exec(timestamp);\n  if(matches != null)\n  {\n    var offset = parseInt(matches[8], 10) * 60 + parseInt(matches[9], 10);\n    if(matches[7] == "-")\n      offset = -offset;\n\n    return new Date(\n      Date.UTC(\n        parseInt(matches[1], 10),\n        parseInt(matches[2], 10) - 1,\n        parseInt(matches[3], 10),\n        parseInt(matches[4], 10),\n        parseInt(matches[5], 10),\n        parseInt(matches[6], 10)\n      ) - offset*60*1000\n    );\n  }\n  return null;\n}