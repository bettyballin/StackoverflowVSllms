SELECT \n    Alternative, \n    SUM(Total) AS Total, \n    SUM(Male) AS Male, \n    SUM(Female) AS Female\nFROM \n    your_table_name\nGROUP BY \n    Alternative;