delete \n   t1 \nfrom \n   tTable t1, tTable t2 \nwhere \n   t1.locationName = t2.locationName and  \n   t1.id > t2.id 