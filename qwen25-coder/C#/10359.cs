var config = new MapperConfiguration(cfg => {\n    cfg.CreateMap<PersonDTO, Person>();\n});\n\nvar mapper = config.CreateMapper();\nvar personToCreate = mapper.Map<Person>(personDto);