package com.wikia.webdriver.TestCases.ArticleCRUDTests;

import org.testng.annotations.Test;

import com.wikia.webdriver.Common.ContentPatterns.PageContent;
import com.wikia.webdriver.Common.Core.CommonFunctions;
import com.wikia.webdriver.Common.Core.Global;
import com.wikia.webdriver.Common.Properties.Properties;
import com.wikia.webdriver.Common.Templates.TestTemplate;
import com.wikia.webdriver.PageObjectsFactory.ComponentObject.AddPhoto.AddPhotoComponentObject;
import com.wikia.webdriver.PageObjectsFactory.ComponentObject.Gallery.GalleryBuilderComponentObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiBasePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiPage.WikiArticlePageObject;
import com.wikia.webdriver.PageObjectsFactory.PageObject.WikiPage.EditMode.WikiArticleEditMode;

public class ArticleFeaturesCRUDTestsAnonymous extends TestTemplate
{
	
	@Test(groups={"ArticleFeatureCRUDAnonymous_001", "ArticleCRUDAnonymous"}) 
//	https://internal.wikia-inc.com/wiki/QA/Core_Features_and_Testing/Manual_Regression_Tests/Image_Serving
	// Test Case 004 Adding images to an article in edit mode
	public void ArticleCRUDAnonymous_001_AddingImage()
	{
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);		
		article.openWikiPage();
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		edit.deleteArticleContent();
		edit.clickPhotoButton();
		article.verifyModalLoginAppeared();
		CommonFunctions.logOut(driver);
	}		
	
	@Test(groups={"ArticleFeatureCRUDAnonymous_002", "ArticleCRUDAnonymous"}) 
//	https://internal.wikia-inc.com/wiki/QA/Core_Features_and_Testing/Manual_Regression_Tests/Image_Serving	
	// Test Case 007  Adding galleries to an article in edit mode
	public void ArticleCRUDAnonymous_002_AddingGallery()
	{
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);		
		article.openWikiPage();
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		edit.deleteArticleContent();
		edit.clickGalleryButton();
		article.verifyModalLoginAppeared();
		CommonFunctions.logOut(driver);
	}
	
	@Test(groups={"ArticleFeatureCRUDAnonymous_003", "ArticleCRUDAnonymous"}) 
//	https://internal.wikia-inc.com/wiki/QA/Core_Features_and_Testing/Manual_Regression_Tests/Image_Serving	
	// Test Case 008 Adding slideshows to an article in edit mode
	public void ArticleCRUDAnonymous_003_AddingSlideshow()
	{
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);		
		article.openWikiPage();
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		edit.deleteArticleContent();
		edit.clickSlideshowButton();
		article.verifyModalLoginAppeared();
		CommonFunctions.logOut(driver);
	}
	
	@Test(groups={"ArticleFeatureCRUDAnonymous_004", "ArticleCRUDAnonymous"})
//	https://internal.wikia-inc.com/wiki/QA/Core_Features_and_Testing/Manual_Regression_Tests/Image_Serving	
	// Test Case 009 Adding sliders to an article in edit mode
	public void ArticleCRUDAnonymous_004_AddingSlider()
	{
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);		
		article.openWikiPage();
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		edit.deleteArticleContent();
		edit.clickSliderButton();
		article.verifyModalLoginAppeared();
		CommonFunctions.logOut(driver);	
	}
	
	@Test(groups={"ArticleFeatureCRUDAnonymous_005", "ArticleCRUDAnonymous"}) 
//	https://internal.wikia-inc.com/wiki/QA/Core_Features_and_Testing/Manual_Regression_Tests/Image_Serving	
	// Test Case 010 Adding videos to an article in edit mode
	public void ArticleCRUDAnonymous_005_AddingVideo()
	{
		CommonFunctions.logOut(driver);
		WikiArticlePageObject article = new WikiArticlePageObject(driver);		
		article.openWikiPage();
		WikiArticleEditMode edit = article.createNewDefaultArticle();
		edit.deleteArticleContent();
//		edit.clickOnVisualButton();
		edit.clickVideoButton();
		article.verifyModalLoginAppeared();
		CommonFunctions.logOut(driver);
	}	
	


}
