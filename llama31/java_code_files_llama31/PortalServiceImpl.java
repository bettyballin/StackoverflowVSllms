/*
 * Decompiled with CFR 0.152.
 */
public class PortalServiceImpl {
    public Contact createPortalAccount(Contact contact) {
        return contact;
    }

    public static void main(String[] stringArray) {
    }

    public static class ServiceFacadeImpl {
        private PortalServiceImpl portalService;
        private ContactDAO contactDAO;

        public void createPortalAccount(Contact contact) {
            Contact contact2 = this.portalService.createPortalAccount(contact);
            this.contactDAO.save(contact2);
        }
    }
}
