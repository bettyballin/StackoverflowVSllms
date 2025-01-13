protected string GetMarkersScript()\n{\n    var sb = new System.Text.StringBuilder();\n    foreach (var mapData in MarkerData) // Assume MarkerData is a List<Map> with Lat, Lng, Title, Text properties\n    {\n        sb.AppendFormat("addMarker(map, {0}, {1}, '{2}', '{3}');",\n            mapData.Lat, mapData.Lng,\n            HttpUtility.JavaScriptStringEncode(mapData.Title),\n            HttpUtility.JavaScriptStringEncode(mapData.Text));\n    }\n    return sb.ToString();\n}