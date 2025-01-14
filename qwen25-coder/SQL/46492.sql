CREATE FUNCTION dbo.SplitString\n(\n    @sInputList VARCHAR(8000), -- List of delimited items\n    @sDelimiter VARCHAR(80)      -- delimiter that separates items\n) \nRETURNS @List TABLE (item VARCHAR(8000))\nBEGIN\n    DECLARE @sItem VARCHAR(8000)\n    \n    WHILE CHARINDEX(@sDelimiter,@sInputList,0) <> 0\n    BEGIN\n        SELECT\n            @sItem=RTRIM(LTRIM(SUBSTRING(@sInputList,1,CHARINDEX(@sDelimiter,@sInputList,0)-1))),\n            @sInputList=RTRIM(LTRIM(SUBSTRING(@sInputList,CHARINDEX(@sDelimiter,@sInputList,0)+LEN(@sDelimiter),LEN(@sInputList))))\n        \n        IF LEN(@sItem) > 0\n            INSERT INTO @List SELECT @sItem\n    END\n    \n    IF LEN(@sInputList) > 0\n        INSERT INTO @List SELECT @sInputList -- Put the last item in\n    \n    RETURN\nEND