create table FruitList (FruitName char(30))\ninsert into FruitList values ('apples'), ('pears'), ('oranges')\n\nselect * from FruitList left outer join AllFruits on AllFruits.fruit = FruitList.FruitName\nwhere AllFruits.fruit is null