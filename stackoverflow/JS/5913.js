function update(layer, url) {\n    var xmlHttp=GetXmlHttpObject(); //you have this defined elsewhere\n\n    if(xmlHttp==null) {\n        alert("Your browser is not supported?");\n    }\n\n    xmlHttp.onreadystatechange = function() {\n        if(xmlHttp.readyState==4 || xmlHttp.readyState=="complete") {\n            document.getElementById(layer).innerHTML=xmlHttp.responseText;\n        } else if (xmlHttp.readyState==1 || xmlHttp.readyState=="loading") {\n            document.getElementById(layer).innerHTML="loading";\n        }\n\n       //etc\n    }\n\n    xmlHttp.open("GET",url,true);\n    xmlHttp.send(null);\n}\n\n\nfunction updateByPk(layer, pk) {\n   url = "get_auction.php?cmd=GetAuctionData&pk="+pk+"&sid="+Math.random();\n   update(layer, url);\n}\n\n\nfunction updateByQuery(layer, query) {\n   url = "get_records.php?cmd=GetRecordSet&query="+query+"&sid="+Math.random();\n   update(layer, url);\n}