person = Person.find(1)\ncar_names = person.cars.pluck(:name)