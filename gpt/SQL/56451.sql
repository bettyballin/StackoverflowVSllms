SELECT Country, City, COUNT(City) AS CityCount\nFROM YourTableName\nGROUP BY Country, City\nORDER BY Country, City;