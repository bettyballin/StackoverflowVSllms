String jqlQuery = "project = \"ProjectName\" AND fixVersion = \"ReleaseVersion\"";\nRemoteIssue[] issues = _soapService.searchIssues(sessionToken, jqlQuery);