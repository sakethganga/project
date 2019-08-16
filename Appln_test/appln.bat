set projectLocation=F:\selenium\Appln_test\
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\appln.xml
pause