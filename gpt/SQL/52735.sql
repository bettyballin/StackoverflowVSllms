USE CMSNET_DEV;\n   GO\n   GRANT SELECT ON dbo.hbl_clnt_cat TO ReadUser;\n   GO\n\n   USE Mattercentre_dev;\n   GO\n   GRANT EXECUTE ON [dbo].[UDSPRBHPRIMBUSTYPE] TO ReadUser;