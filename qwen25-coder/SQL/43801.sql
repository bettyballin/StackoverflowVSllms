select \n    xml.value('sum(/List/value/data(xs:decimal(.)))', 'decimal') as sum\nfrom \n    (select cast('<List><value>0</value><value>0</value></List>' as xml) xml) a