Imports AutoMapper\n\nPublic Class LocationMapperProfile\n    Inherits Profile\n\n    Public Sub New()\n        CreateMap(Of ServiceLocation, ApplicationLocation)()\n            .ForMember(Function(dest) dest.Id, Function(opt) opt.MapFrom(Function(src) src.Id))\n            .ForMember(Function(dest) dest.Name, Function(opt) opt.MapFrom(Function(src) src.Name))\n            .ForMember(Function(dest) dest.Description, Function(opt) opt.MapFrom(Function(src) src.Description))\n    End Sub\nEnd Class\n\nPublic Function ConvertServiceLocationsToApplicationLocationsWithAutoMapper(serviceLocations As ServiceLocation()) As List(Of ApplicationLocation)\n    Dim config = New MapperConfiguration(Sub(cfg) cfg.AddProfile(Of LocationMapperProfile)())\n    Dim mapper = config.CreateMapper()\n\n    Return mapper.Map(Of List(Of ApplicationLocation))(serviceLocations)\nEnd Functio