public class GeoReverseLookupRequester {

    // assuming location is your string address variable
    String location = "1600 Amphitheatre Parkway, Mountain View, CA"; // example location

    public static void main(String[] args) {
        GeoReverseLookupRequester requester = new GeoReverseLookupRequester();
        requester.lookup();
    }

    public void lookup() {
        String serviceUrl = "http://api.maps.yahoo.com/MapsService/V1/geocode?appid={your_app_id}&country=US&location=" + location;

        YGeoReverseLookupService geoservice = new YGeoReverseLookupService(serviceUrl);
        geoservice.addPrimaryGeoResponseListener(new GeoPlaceCodeCallback() {
            @Override
            public void onResponse(int transactionId, GeoReverseGeocodeResponse response) {
                // Assuming a single correct result for simplicity
                YGeoPoint point = new YGeoPoint(
                    response.getResultList().getResponseAt(0)
                        .getCountryCityStatePostalCodeLocation().getLatitude(),
                    response.getResultList().getResponseAt(0)
                        .getCountryCityStatePostalCodeLocation().getLongitude()
                );
                // now you have your YGeoPoint for the location
            }
        });
        geoservice.lookup();
    }

    // Stub classes for compilation

    class YGeoReverseLookupService {
        public YGeoReverseLookupService(String serviceUrl) { }
        public void addPrimaryGeoResponseListener(GeoPlaceCodeCallback callback) { }
        public void lookup() { }
    }

    interface GeoPlaceCodeCallback {
        void onResponse(int transactionId, GeoReverseGeocodeResponse response);
    }

    class GeoReverseGeocodeResponse {
        public ResultList getResultList() { return new ResultList(); }

        class ResultList {
            public Response getResponseAt(int index) { return new Response(); }
        }

        class Response {
            public Location getCountryCityStatePostalCodeLocation() { return new Location(); }
        }

        class Location {
            public double getLatitude() { return 0.0; }
            public double getLongitude() { return 0.0; }
        }
    }

    class YGeoPoint {
        public YGeoPoint(double latitude, double longitude) { }
    }

}