class HttpResponseSeeOther(HttpResponseRedirect):\n    status_code = 303\n\nreturn HttpResponseSeeOther('/other-url/')