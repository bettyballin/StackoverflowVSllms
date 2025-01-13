public class FavoriteMovieWebService : IFavoriteMovieWeb\n{\n    private readonly IFavoriteMovie _service;\n\n    public FavoriteMovieWebService(IFavoriteMovie service)\n    {\n        _service = service;\n    }\n\n    public MyFavoriteMovie GetItem()\n    {\n        try\n        {\n            return _service.GetItem();\n        }\n        catch (FaultException<MyFavoriteMovieFault> ex)\n        {\n            throw new WebProtocolException(HttpStatusCode.NotFound, ex.Detail.Message, null);\n        }\n    }\n}