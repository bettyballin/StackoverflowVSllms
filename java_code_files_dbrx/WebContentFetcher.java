public class WebContentFetcher {

    public JournalArticle getWebContentById(long articleId) throws SystemException, PortalException {
        return JournalArticleLocalServiceUtil.getLatestArticle(
            GroupLocalServiceUtil.fetchFriendlyURLGroup("Your Friendly URL"),
            "journal",
            new Long(articleId).toString()
        );
    }

}

class JournalArticle {
    // Empty class for compilation
}

class SystemException extends Exception {
    // Empty class for compilation
}

class PortalException extends Exception {
    // Empty class for compilation
}

class Group {
    // Empty class for compilation
}

class GroupLocalServiceUtil {
    public static Group fetchFriendlyURLGroup(String url) {
        return new Group();
    }
}

class JournalArticleLocalServiceUtil {
    public static JournalArticle getLatestArticle(Group group, String journal, String articleId)
            throws SystemException, PortalException {
        return new JournalArticle();
    }
}