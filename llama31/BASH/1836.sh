logparser -i:HTTPERR "SELECT TOP 10 date, time, cs-method, cs-uri-stem, sc-status FROM 'C:\Windows\System32\LogFiles\HTTPERR\httperr.log' WHERE sc-status = 503"