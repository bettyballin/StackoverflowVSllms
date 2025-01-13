/*
 * Decompiled with CFR 0.152.
 */
public static class PortalServiceImpl.ServiceFacadeImpl {
    private PortalServiceImpl portalService;
    private ContactDAO contactDAO;

    public void createPortalAccount(Contact contact) {
        Contact contact2 = this.portalService.createPortalAccount(contact);
        this.contactDAO.save(contact2);
    }
}
