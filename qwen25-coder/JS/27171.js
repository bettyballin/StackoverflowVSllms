// Assuming serverTimeUTC is passed from server as a string or timestamp\nconst serverTimeUTC = new Date(); // Example server time in UTC\nconst clientLocalTime = serverTimeUTC.toLocaleString();\n\nconsole.log(clientLocalTime);