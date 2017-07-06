# OysterCard-master
OysterCard solution in parts

Oyster Card Application
--------------------------------------------------------------
This README is based on the released beta version (1.0)
--------------------------------------------------------------
Unit Test Cases :
Location - src\test\java\

Source Code :
		Location - \src\main\java

Resources :
		Location - src\resources

Root Folder :
		Name - OysterCard-master

--------------------------------------------------------------

API Guide :
----------------

Start Journey Example :
OysterCardApplication oysterCardApp = new OysterCardApplication();
Card oysterCard = TestHelper.INSTANCE.formOysterCard("1", "Holborn", JourneyType.TUBE, JourneyStatus.INCOMPLETE);
Card oysterCardAfterJourneyLeg1 = oysterCardApp.startJourney(CardHelper.INSTANCE.topUpOysterCard(oysterCard));

-------------------

End Journey : 
		Card journeyLeg1Completed = oysterCardApp.endJourney(TestHelper.INSTANCE.updateOysterCard(oysterCardAfterJourneyLeg1, "Earl's Court"));
-------------------

Print Invoice:
		oysterCardApp .printBill()
---------------------

Application Dependency : For more details, refer pom.xml
			maven-surefire-plugin
			junit
			jackson-core
			jackson-databind
			jackson-annotations

--------------------------------------------------------------
Maven goal to compile & run junit test case : mvn compile test

mvn clean eclipse:clean eclipse:eclipse compile test
--------------------------------------------------------------------------------------
