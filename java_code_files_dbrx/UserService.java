public class UserService {

    // Definition of annotations
    public @interface GET {}
    public @interface HeaderParam {
        String value();
    }
    public @interface Path {
        String value();
    }
    public @interface Produces {
        String value();
    }

    // Definition of Response class
    public static class Response {
        public static ResponseBuilder ok() {
            return new ResponseBuilder();
        }

        public static class ResponseBuilder {
            public Response build() {
                return new Response();
            }
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUserById(@HeaderParam("Authorization") String authorization) {
        // Implement your logic here
        return Response.ok().build();
    }
}