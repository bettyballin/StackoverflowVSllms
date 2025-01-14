public class PermissionsResultHandler extends SuperClass {

    public static final int MY_PERMISSIONS_REQUEST_READ_SMS = 1;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_SMS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted: query SMS here
                } else {
                    // Permission denied: handle the error
                }
                break;
        }
    }

    public static void main(String[] args) {
    }
}

class SuperClass {
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // Do nothing
    }
}

@interface NonNull {
}

class PackageManager {
    public static final int PERMISSION_GRANTED = 0;
}