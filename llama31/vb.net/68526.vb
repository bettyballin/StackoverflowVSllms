<%\n    Dim maintenanceMode\n    maintenanceMode = True ' Set this to False when maintenance is complete\n\n    If maintenanceMode Then\n        Response.Redirect "maintenance.asp"\n    End If\n%>