case "json":\n    gdata = JSON.stringify(gdata); //ASP.NET expects JSON as a string\n    $.ajax({ url: ts.p.url, \n             type: ts.p.mtype, \n             dataType: "json", \n             contentType: "application/json; charset=utf-8", //required by ASP.NET\n             data: gdata, \n             complete: function(JSON, st) { if (st == "success") { addJSONData(cleanUp(JSON.responseText), ts.grid.bDiv); if (loadComplete) { loadComplete(); } } }, \n             error: function(xhr, st, err) { if (loadError) { loadError(xhr, st, err); } endReq(); }, \n             beforeSend: function(xhr) { if (loadBeforeSend) { loadBeforeSend(xhr); } } });\n    if (ts.p.loadonce || ts.p.treeGrid) { ts.p.datatype = "local"; }\n    break;