[WebMethod]\npublic LatitudeLogitudeMessage[] GetPoints(string postCodes)\n{\n    string[] postCodeArray = postCodes.Split(",".ToCharArray());\n\n    LatitudeLogitudeMessage[] pointArray = \n                   new LatitudeLogitudeMessage[postCodeArray.Length];\n    int index = 0;\n    foreach (string postCode in postCodeArray)\n    {\n        pointArray[index] = GetPoint(postCode);\n        index++;\n    }\n\n    return pointArray;\n}