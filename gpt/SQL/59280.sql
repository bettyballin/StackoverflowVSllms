DECLARE @tbXML TABLE (\n    ParameterID INT,\n    ParameterValue XML\n);\n\n-- Sample data insertion\nINSERT INTO @tbXML (ParameterID, ParameterValue)\nVALUES\n(1, '<USER><User ID="1" Name="Billy"/><User ID="2" Name="Billy"/><MANAGER><User ID="1" Name="Billy"/></MANAGER></USER>'),\n(2, '<USER><User ID="1" Name="John"/><User ID="2" Name="Billy"/><MANAGER><User ID="1" Name="Billy"/></MANAGER></USER>'),\n(3, '<USER><User ID="1" Name="David"/><User ID="2" Name="Billy"/><MANAGER><User ID="1" Name="Billy"/></MANAGER></USER>');