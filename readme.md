# Selenium Tests
This repository contains [Selenium](http://seleniumhq.org/) tests for the [Wikia App](https://github.com/Wikia/app).

## Dependencies

1. Make sure you have [Java](http://www.java.com/) and [Maven](http://maven.apache.org/) installed on your system, if not follow the vendor instructions for installing them on your operating system.
2. In order to run tests in CHROME browser make sure you have [chromedriver](http://code.google.com/p/chromedriver/downloads/list) and it is accessibile
    * in Linux OS family it would be in /usr/bin/ for example
    * in Windows OS family you should export your chromedriver localization to system path

## Adding Tests
Please remember to keep this repository up to date as the tests become worthless otherwise. A good rule of thumb is to add a new test that covers whatever bug you're fixing so we can track regressions on it. Also, make sure to code your tests in a cross-operating system compliant manor as it's valid to run them in Windows, Mac or Linux environments.

## Running Tests

The following steps should get you set up for running Selenium tests locally on your machine:

1. Clone this repository to your local machine (not your devbox).
2. Clone selenium-config repository to the same folder (eg. myfolder/selenium-tests and myfolder/selenium-config)
3. Create symlinks for `/selenium-config/config.xml` and `/selenium-config/captcha.txt` (note the leading slash) that point to these files in your [selenium-config](https://github.com/Wikia/selenium-config) repository.
4. Open up a terminal and navigate to the root directory of the repository.

Using Maven, you may now run any tests you want on whatever database and domain you want:

    mvn clean test -Dbrowser=FF -Dbase-address=<address> -Dgroups=<group> -Dlive-domain=<address>

Example command:

    mvn clean test -Dbrowser=FF -Dbase-address=http://mediawiki119.wikia.com/ -Dgroups=Login

If everything goes right it should log in as a QATestsUser.

### Parameters

The following are valid test parameters:

* `-Dbrowser` - Which browser to use, for example "CHROME"
* `-Dbase-address` - The base URL to run in the browser, for example "http://yourname.wikia-dev.com/"
* `-Dgroups` - (Optional) Which test groups to run, for example "Chat". Optional. Uses all tests if omitted
* `-Dlive-domain` - (Optional) The base URL to run in the browser, for example "http://www.wikia.com/". Only required for Hubs tests

### Browsers

The following are valid for use in the `-Dbrowser` parameter:

* FF
* CHROME
* IE
* GHOST (phantomjs)

### Groups

The following are valid for use in the `-Dgroups` parameter:

* ArticleCRUDAdmin
* ArticleCRUDAnonymous
* ArticleFeaturesCRUDAdmin
* CategoriesTestsAnonymous
* Chat
* CNW_lang
* CNW
* Hubs
* ImageServing
* Login
* MessageWall
* RTE
* Search
* Toolbar

## Reading Logs

Most tests write logs and take screenshots while they run which provide further information about what happened if they failed. These files reside in the `./logs` directory and can be viewed locally in your browser by navigating to that folder.
