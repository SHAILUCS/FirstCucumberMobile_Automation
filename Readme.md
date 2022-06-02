# Parallel execution of tests on mobile devices
	All you need to do is, spawn two devices(emulators) on your machine and install the latest app under test on them.
	
	This framework will automatically start the appium server and link with those devices[device information to be put in testng.xml file]
	
	If you want to run the tests in parallel in more than 2 devices then, add another test block in the testng.xml file and create another runner file and divide the app's feature files in one more folder (device3)

1. Allure Report with History
1. Browser Stack for cloud execution(w/o udid)