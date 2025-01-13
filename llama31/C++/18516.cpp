// Assume 'response' is an object that allows you to set HTTP headers and response body\nresponse->SetHeader("Content-Disposition", "attachment; filename=example.xlsx");\nresponse->SetHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");\n\n// Create an HTML wrapper page\nstd::string html = "<html><head><meta http-equiv='refresh' content='2; url=/main-page'></head><body>Your file has been generated. Click <a href='/main-page'>here</a> to go back to the main screen.</body></html>";\n\n// Set the response body to the HTML wrapper page\nresponse->SetResponseBody(html);