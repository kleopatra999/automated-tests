package com.wikia.webdriver.TestCases.VideoTests;

import org.testng.annotations.Test;

import com.wikia.webdriver.Common.ContentPatterns.PageContent;
import com.wikia.webdriver.Common.ContentPatterns.VideoContent;
import com.wikia.webdriver.Common.Core.CommonFunctions;
import com.wikia.webdriver.Common.Core.Global;
import com.wikia.webdriver.Common.Logging.PageObjectLogging;
import com.wikia.webdriver.Common.Properties.Properties;
import com.wikia.webdriver.Common.Templates.TestTemplate;
import com.wikia.webdriver.PageObjectsFactory.ComponentObject.MiniEditor.MiniEditorComponentObject;
import com.wikia.webdriver.PageObjectsFactory.ComponentObject.Vet.VetAddVideoComponentObject;
import com.wikia.webdriver.PageObjectsFactory.ComponentObject.Vet.VetOptionsComponentObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.MessageWall.MessageWallPageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.Blog.SpecialCreateBlogPageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.SpecialVideosPageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.Special.SpecialVideosPageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiPage.WikiArticlePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiPage.EditMode.WikiArticleEditMode;

/*
 * Documentation:
 * https://docs.google.com/a/wikia-inc.com/spreadsheet/ccc?key=0AtG89yMxyGSadEtPY28ydDB4czkydXNmMkJVQ2NGR0E#gid=7
 */

public class VetAddingVideoTests extends TestTemplate {
	
	String desiredVideoName;
	
	@Test(groups = {"VetTests001", "VetTests", "VetAddVideo"})
	public void Vet_Tests_001_SpecialVideosProvider() {
		CommonFunctions.logOut(driver);
		WikiBasePageObject wiki = new WikiBasePageObject(driver);
		wiki.openWikiPage();
		CommonFunctions.logInCookie(Properties.userName, Properties.password, driver);	
		SpecialVideosPageObject specialVideos = wiki.openSpecialVideoPage();
		VetAddVideoComponentObject vetAddingVideo = specialVideos.clickAddAVideo();
		vetAddingVideo.addVideoByUrl(VideoContent.youtubeVideoURL2);
		specialVideos.verifyVideoAdded(VideoContent.youtubeVideoURL2name);
	}
	
	@Test(groups = {"VetTests002", "VetTests", "VetAddVideo"})
	public void Vet_Tests_002_SpecialVideosLibrary() {
		CommonFunctions.logOut(driver);
		WikiBasePageObject wiki = new WikiBasePageObject(driver);
		wiki.openWikiPage();
		CommonFunctions.logInCookie(Properties.userName, Properties.password, driver);	
		SpecialVideosPageObject specialVideos = wiki.openSpecialVideoPage();
		VetAddVideoComponentObject vetAddingVideo = specialVideos.clickAddAVideo();
		vetAddingVideo.addVideoByQuery(VideoContent.wikiaVideoQuery, 0);
		specialVideos.verifyVideoAdded(vetAddingVideo.getVideoName());
	}
	
	@Test(groups = {"VetTests003", "VetTests", "VetAddVideo"})
	public void Vet_Tests_003_RelatedVideosProvider() {
		CommonFunctions.logOut(driver);
		WikiBasePageObject wiki = new WikiBasePageObject(driver);
		wiki.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticleEditMode rVmoduleMessageEdit = new WikiArticleEditMode(driver);		
		rVmoduleMessageEdit.editArticleByName("MediaWiki:RelatedVideosGlobalList");
		rVmoduleMessageEdit.deleteUnwantedVideoFromMessage(VideoContent.youtubeVideoURL2name);
		WikiArticlePageObject article = rVmoduleMessageEdit.clickOnPublishButton();
		article.openRandomArticleByUrl();
		article.verifyRVModulePresence();
		VetAddVideoComponentObject vetAddingVideo = article.clickOnAddVideoRVModule();;
		vetAddingVideo.addVideoByUrl(VideoContent.youtubeVideoURL2);
		article.verifyVideoAddedToRVModule(VideoContent.youtubeVideoURL2name);
	}
	
	@Test(groups = {"VetTests004", "VetTests", "VetAddVideo"})
	public void Vet_Tests_004_RelatedVideosLibrary() {
		CommonFunctions.logOut(driver);
		WikiBasePageObject wiki = new WikiBasePageObject(driver);
		wiki.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticleEditMode rVmoduleMessageEdit = new WikiArticleEditMode(driver);		
		rVmoduleMessageEdit.editArticleByName("MediaWiki:RelatedVideosGlobalList");
		rVmoduleMessageEdit.deleteUnwantedVideoFromMessage(VideoContent.youtubeVideoURL2name);
		WikiArticlePageObject article = rVmoduleMessageEdit.clickOnPublishButton();
		article.openRandomArticleByUrl();
		article.verifyRVModulePresence();
		VetAddVideoComponentObject vetAddingVideo = article.clickOnAddVideoRVModule();
		vetAddingVideo.addVideoByQuery(VideoContent.wikiaVideoQuery, 1);
		article.verifyVideoAddedToRVModule(vetAddingVideo.getVideoName());
	}
	
	@Test(groups = {"VetTests005", "VetTests", "VetAddVideo"})
	public void Vet_Tests_005_ArticlePlaceholderPublishedPageProvider() {
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);
		article.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		edit.clickOnPublishButton();
		article.verifyPageTitle(article.getPageName());
		VetAddVideoComponentObject vetAddingVideo = article.clickAddVideoPlaceholder();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByUrl(VideoContent.youtubeVideoURL);
		vetOptions.submit();
		article.verifyVideoOnThePage();
	}
	
	@Test(groups = {"VetTests006", "VetTests", "VetAddVideo"})
	public void Vet_Tests_006_ArticlePlaceholderPublishedPageLibrary() {
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);
		article.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		edit.clickOnPublishButton();
		article.verifyPageTitle(article.getPageName());
		VetAddVideoComponentObject vetAddingVideo = article.clickAddVideoPlaceholder();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByQuery(VideoContent.wikiaVideoQuery, 0);
		vetOptions.submit();
		article.verifyVideoOnThePage();
	}
		
	@Test(groups = {"VetTests007", "VetTests", "VetAddVideo"})
	public void Vet_Tests_007_ArticlePlaceholderEditModePageProvider() {
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);
		article.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		VetAddVideoComponentObject vetAddingVideo = edit.clickModifyButtonVideoPlaceholder();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByUrl(VideoContent.youtubeVideoURL);
		vetOptions.setCaption(PageContent.caption);
		vetOptions.submit();
		edit.verifyVideoInEditMode(PageContent.caption);
		edit.clickOnPublishButton();
		article.verifyPageTitle(article.getPageName());
		article.verifyVideoOnThePage();
	}
	
	@Test(groups = {"VetTests008", "VetTests", "VetAddVideo"})
	public void Vet_Tests_008_ArticlePlaceholderEditModePageLibrary() {
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);
		article.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		VetAddVideoComponentObject vetAddingVideo = edit.clickModifyButtonVideoPlaceholder();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByQuery(VideoContent.wikiaVideoQuery, 0);
		vetOptions.setCaption(PageContent.caption);
		vetOptions.submit();
		edit.verifyVideoInEditMode(PageContent.caption);
		edit.clickOnPublishButton();
		article.verifyPageTitle(article.getPageName());
		article.verifyVideoOnThePage();
	}	
	
	@Test(groups = {"VetTests009", "VetTests", "VetAddVideo"})
	public void Vet_Tests_009_BlogProvider() {
		CommonFunctions.logOut(driver);
		SpecialCreateBlogPageObject blogEdit = new SpecialCreateBlogPageObject(driver);
		blogEdit.openWikiPage();
		CommonFunctions.logInCookie(Properties.userName, Properties.password);
		String blogPostTitle = PageContent.blogPostNamePrefix + blogEdit.getTimeStamp(); 
		blogEdit = blogEdit.createBlogFormUrl(blogPostTitle);
		VetAddVideoComponentObject vetAddingVideo = blogEdit.clickVideoButton();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByUrl(VideoContent.youtubeVideoURL);
		vetOptions.setCaption(PageContent.caption);
		vetOptions.submit();
		blogEdit.verifyVideoInEditMode(PageContent.caption);
		WikiArticlePageObject article = blogEdit.clickOnPublishButton();
		article.verifyVideoOnThePage();
	}
	
	@Test(groups = {"VetTests010", "VetTests", "VetAddVideo"})
	public void Vet_Tests_010_BlogLibrary() {
		CommonFunctions.logOut(driver);
		SpecialCreateBlogPageObject blogEdit = new SpecialCreateBlogPageObject(driver);
		blogEdit.openWikiPage();
		CommonFunctions.logInCookie(Properties.userName, Properties.password);
		String blogPostTitle = PageContent.blogPostNamePrefix + blogEdit.getTimeStamp(); 
		blogEdit = blogEdit.createBlogFormUrl(blogPostTitle);
		VetAddVideoComponentObject vetAddingVideo = blogEdit.clickVideoButton();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByQuery(VideoContent.wikiaVideoQuery, 0);
		vetOptions.setCaption(PageContent.caption);
		vetOptions.submit();
		blogEdit.verifyVideoInEditMode(PageContent.caption);
		WikiArticlePageObject article = blogEdit.clickOnPublishButton();
		article.verifyVideoOnThePage();
	}	
	
	@Test(groups = {"VetTests011", "VetTests", "VetAddVideo"})
	public void Vet_Tests_011_CommentsProvider() {
		CommonFunctions.logOut(driver);
		WikiBasePageObject wiki = new WikiBasePageObject(driver);
		wiki.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);
		article.openRandomArticle();
		article.triggerCommentArea();
		MiniEditorComponentObject mini = new MiniEditorComponentObject(driver);
		VetAddVideoComponentObject vetAddingVideo = mini.clickAddVideo();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByUrl(VideoContent.youtubeVideoURL2);
		vetOptions.setCaption(PageContent.caption);
		vetOptions.submit();
		mini.verifyVideoMiniEditor();
		article.clickSubmitButton();
		article.verifyCommentVideo(VideoContent.youtubeVideoURL2name);
	}
	
	@Test(groups = {"VetTests012", "VetTests", "VetAddVideo"})
	public void Vet_Tests_012_CommentsLibrary() {
		CommonFunctions.logOut(driver);
		WikiBasePageObject wiki = new WikiBasePageObject(driver);
		wiki.openWikiPage();
		CommonFunctions.logInCookie(Properties.userNameStaff, Properties.passwordStaff);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);
		article.openRandomArticle();
		article.triggerCommentArea();
		MiniEditorComponentObject mini = new MiniEditorComponentObject(driver);
		VetAddVideoComponentObject vetAddingVideo = mini.clickAddVideo();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByQuery(VideoContent.wikiaVideoQuery, 0);
		vetOptions.setCaption(PageContent.caption);
		desiredVideoName = vetOptions.getVideoName();
		vetOptions.submit();
		mini.verifyVideoMiniEditor();
		article.clickSubmitButton();
		article.verifyCommentVideo(desiredVideoName);
	}
	
	@Test(groups = {"VetTests013", "VetTests", "VetAddVideo"})
	public void Vet_Tests_013_MessageWallProvider() {
		CommonFunctions.logOut(driver);
		MessageWallPageObject wall = new MessageWallPageObject(driver);
		String timeStamp = wall.getTimeStamp();
		String title = PageContent.messageWallTitlePrefix + timeStamp;
		wall.openWikiPage();
		CommonFunctions.logInCookie(Properties.userName, Properties.password);
		wall.openMessageWall(Properties.userName);
		wall.triggerMessageArea();
		MiniEditorComponentObject mini = new MiniEditorComponentObject(driver);
		wall.writeMessage(title, "");
		VetAddVideoComponentObject vetAddingVideo = mini.clickAddVideo();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByUrl(VideoContent.youtubeVideoURL2);
		vetOptions.setCaption(PageContent.caption);
		vetOptions.submit();
		mini.verifyVideoMiniEditor();
		wall.clickPostButton();
		wall.verifyPostedMessageVideo(title);
	}
	
	@Test(groups = {"VetTests014", "VetTests", "VetAddVideo"})
	public void Vet_Tests_014_MessageWallLibrary() {
		CommonFunctions.logOut(driver);
		MessageWallPageObject wall = new MessageWallPageObject(driver);
		String timeStamp = wall.getTimeStamp();
		String title = PageContent.messageWallTitlePrefix + timeStamp;
		wall.openWikiPage();
		CommonFunctions.logInCookie(Properties.userName, Properties.password);
		wall.openMessageWall(Properties.userName);
		wall.triggerMessageArea();
		MiniEditorComponentObject mini = new MiniEditorComponentObject(driver);
		wall.writeMessage(title, "");
		VetAddVideoComponentObject vetAddingVideo = mini.clickAddVideo();
		VetOptionsComponentObject vetOptions = vetAddingVideo.addVideoByQuery(VideoContent.wikiaVideoQuery, 0);
		vetOptions.setCaption(PageContent.caption);
		vetOptions.submit();
		mini.verifyVideoMiniEditor();
		wall.clickPostButton();
		wall.verifyPostedMessageVideo(title);
	}
}
