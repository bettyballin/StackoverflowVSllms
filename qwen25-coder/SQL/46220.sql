UPDATE YourTable\nSET YourXmlColumn = cast(replace(cast(YourXmlColumn as nvarchar(max)), 'Spolsky & Atwood', 'Spolsky &amp; Atwood') as xml)\nWHERE SomeCondition;