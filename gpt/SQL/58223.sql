select a.id, b.id, b.address_1\nfrom person a\ninner join address b\non a.id = b.id