/*
 * Decompiled with CFR 0.152.
 */
public class RegionFilterEnabler {
    private User currentUser = new User(this);
    Session session = this.getSession();

    public RegionFilterEnabler() {
        this.session.enableFilter("regionFilter").setParameter("region", this.currentUser.getRegion());
    }

    private Session getSession() {
        return new Session();
    }

    public static void main(String[] stringArray) {
    }

    private class User {
        private User(RegionFilterEnabler regionFilterEnabler) {
        }

        public String getRegion() {
            return "defaultRegion";
        }
    }

    private class Session {
        private Session() {
        }

        public Filter enableFilter(String string) {
            return new Filter(RegionFilterEnabler.this);
        }
    }

    private class Filter {
        private Filter(RegionFilterEnabler regionFilterEnabler) {
        }

        public void setParameter(String string, String string2) {
        }
    }
}
