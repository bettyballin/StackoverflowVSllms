INSERT INTO aspnet_Profile (UserId, PropertyNames, PropertyValuesString, PropertyValuesBinary)\nVALUES (\n    @UserId,\n    'GuidProperty:S:0:1:StringProperty1:S:1:2:StringProperty2:S:3:4:IntegerProperty:I:5:6:',\n    'xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx|Value1|Value2|',\n    123\n)