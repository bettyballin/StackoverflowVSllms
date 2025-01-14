DECLARE \n    @valueXPath varchar(255), \n    @criteriaXPath varchar(255),\n    @intCriteriaVal int\n\nSET @valueXPath = '/operationsManual/sections/section/contentItem'\nSET @criteriaXPath = '(/operationsManual/sections/section/contentItem/imageContentItem/imageId)[1]'\nSET @intCriteriaVal = 131\n\nSELECT * FROM fnGetOpManualXMLDataFromInt(@valueXPath, @criteriaXPath, @intCriteriaVal)