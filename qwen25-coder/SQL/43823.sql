DECLARE @xmlData XML;\nSET @xmlData = '<soap:Envelope xmlns:xsi="[URI]" xmlns:xsd="[URI]" xmlns:soap="[URI]">\n  <soap:Body>\n    <RunPackage xmlns="[URI]">\n      <xmlDoc>\n        <Request>\n          <SubscriberCode>76547654</SubscriberCode>\n          <CompanyCode></CompanyCode>\n        </Request>\n      </xmlDoc>\n    </RunPackage>\n  </soap:Body>\n</soap:Envelope>';\n\nWITH XMLNAMESPACES ('[URI]' AS soap, '[URI]' as ns)\nSELECT \n    T2.Loc.value('(Request/SubscriberCode/text())[1]', 'NVARCHAR(50)') as 'SubscriberCode'\nFROM \n    (SELECT @xmlData AS RequestXML) AS TempWorksRequest\nCROSS APPLY \n    RequestXML.nodes('soap:Envelope/soap:Body/ns:RunPackage/ns:xmlDoc') AS T2(Loc);