**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |    28    |
| -------------- | ---      |
| Student Names: |          |
| Harshit Sharma | 30092470 |
| Heidi Toews    | 30094995 |
| Muhammad Khan  | 30092202 |
| Shamis Ali     | 30096335 |

# Introduction
In this lab we learned about mutation testing and GUI testing. Mutation testing is injecting faults into the code to see how effective a test suite is. The more mutations a test suite is able to catch, the more effective it is. In this lab, we used mutation testing to evaluate and improve our test suites for the DataUtilities and Range classes. 
GUI testing involves making sure that all of the functionality in a GUI is working correctly. We used Selenium to design a simple test suite for the Best Buy website. 

# Analysis of 10 Mutants of the Range class 
Mutant #1 - testLowerMin
Mutation: Replace Equality Check with True 
Location: line 241
Analysis:
In the method CombineIgnoreNaN(Range range1, Range range2), the if condition of range2==null && range2.isNaNRange() was changed to true. This mutation would have caused the program to try to combine 2 Range objects. By changing this to true, the method would return null even when range2 isn’t null. This means that the 2 arrays will not combine.
Mutant #2 - combineWithNan
Mutation: mutated return of Object value for org/jfree/data/Range::combineIgnoringNaN to ( if (x != null) null else throw new RuntimeException )
Location: Line 256
Analysis:In the method combineWithNan, it checks if the return return value of the object is equal to what was asked and if it is not null then it fails the test, thus killing the mutant
Mutant #3 - testCombineIgnoringNaNMin
Mutation: replaced call to org/jfree/data/Range::min with argument
Location: Line 253 
Analysis: In method CombineIgnoringNaN(Range range1, Range range2), the min function was replaced with some random argument (the argument is unknown). This mutation can likely cause the ranges to be combined incorrectly as the method no longer has the minimum of the 2 Range parameters, instead likely returning a fixed value. The TestCombineIgnoringNaNMin() method accounts for this by sending a Range object with NaN ranges as parameters, thus showing that the method doesn’t accurately return the lower bound of the combined range.
Mutant #4 - constrainOutsideLowerRange
Mutation: greater or equal to less than
Location: Line 193
Analysis: in the method constrain(double value), the >= sine was changed to <=. This would have caused the method to ignore that value may not be within the Range object and would have caused the method to return the value and not the range. This was caught by setting the value to 1 and calling the method as an instance of a range object with range of (2,6).
Mutant #5 - intersectrangeFalse
Mutation: less or equal sign to greater
Location: Line 19
Analysis: In the method intersects(int b0, int b1) the <= sign was replaced with >. This would cause the method to ignore if the lowerbound was actually higher. This was the exact scenario used to catch this mutation.
Mutant #6 - testClosestValueInRange
Mutation: Negated double local variable number 1
Location: Line 188
Analysis: In this method, the local variable which had been created had been negated by the mutations and this was killed by test, as the test ensured that the local value could not be negated as it is the return value
Mutant #7 - testRangeExpandNegative
Mutation: removed call to org/jfree/data/Range::getLength 
Location: Line 330
Analysis: In method expand(Range range, int lowerbound,int upperbound), the call to the getLength() of the range object was removed, this would cause the calculation for the lower bound to be inaccurate and could affect the result for the output of the method. The testRangeExpandNegative method accounts for this by using negative values and finding the error in the calculation.
Mutant #8 - testCombinedNull
Mutation: less Than to greater than or equal
Location: Line 190
Analysis: in the method constrain(double value), the < sine was changed to >=. This would have caused the method to ignore that the value may be less than the Range object and would have caused the method to return the value that is less than the range and could have caused problems with negative numbers in particular. This was caught by setting the value to -50 and calling the method as an instance of a range object with range of (-1.0,1.0).
Mutant #9 - testClosestSmallValue
Mutation: Incremented (a++) double local variable number 1
Location: Line 188
Analysis: In this test, it checks if the double variable had been increased by 1 and if that affects the output which does affect the output as that results in input being within the range and resulting in the out being returned without being changed and thus failing the tests
Mutant #10 - shiftZeroCrossing
Mutation: Substituted 0.0 with 1.0 
Location: Line 387
Analysis: This test ensures that when the zero crossing is substituted with 1.0, that the test fails as the example range should not be changed due to the delta being 0 but as the delta changes, this results in the shift changing


# Report all the statistics and the mutation score for each test class
Data Utilities Methods Updated
![image](https://raw.githubusercontent.com/seng438-winter-2022/seng438-a4-Harsh-S7/main/media/afterDU.png?token=GHSAT0AAAAAABQ3WOISGEGN5ITYLGAZAYWAYRVLKEQ)
Equal
Explanation - This method, TestEqualTrue, was aimed to catch a mutant where a return statement was changed from (b==null) to true. The equal(double[][] a, double[][] b) method is meant to compare 2 double arrays and see if they have the same values and lengths. The Mutation would have caused the method to return true even when a is null and b isn’t. The Test EqualTrue method checked this by making a=null but b={{1},{1}} and thus finding the error.
CalculateRowTotal
Explanation - This methodm, RowTotTNm,  was aimed to catch a mutant where an if Condition was changed from n != null to true. The calculateRowTotal(Values2D data, int row, int[] validCols) method is meant to find the total of all indexes found in validCols and in the specified row of data. The Mutation would have caused the method to return count the null values within the calculation. The test RowTotTN method checked this by making the last value in row 0 a null value and thus finding the error.
Range Methods Updated
![image](https://raw.githubusercontent.com/seng438-winter-2022/seng438-a4-Harsh-S7/main/media/afterR.png?token=GHSAT0AAAAAABQ3WOISWUPT6G6ENBJQOLJ6YRVLLLA)
Shift
Explanation - This method, was added to check if the conditional statment was removed and if the conditional statement was negated, how that would affect the method and the class. This method checks if the returned value was replaced with null for org/jfree/data/Range::shift and if it was it kills the mutation.
Constrain
Explanation - Within constrain, there is a multitude of ways that mutation can affect the program as local variables can be increased by 1 and this increase changes constrain function and thus to address these local variable change mutations, test cacses were created to address when the local variables were incremneted or decremented.
CombineIgnoringNaN
Explanation - For combineIgnoringNan, there were multiple test methods that were created in order to ensure there was enoguh coverage, as combine ignoring Nan had a lot of mutation that survived despite the previous tests. There were tests created where the 
Intersects
Explanation - Within intersect, there can be different ways to pass the intersecting Range to the method and there is a test case added which passes a range that is not allowed and this addresses the negational condition which should be addressed if the mutation was created by the pittest and should return false but if it returns true, the test fails

# Analysis drawn on the effectiveness of each of the test classes
Once we had added the above stated test cases, the figures below show how much the mutation coverages improved by, data utilities went to 90% and range went to 79%.
Data Utilities
Before
![image](https://raw.githubusercontent.com/seng438-winter-2022/seng438-a4-Harsh-S7/main/media/beforeDU.png?token=GHSAT0AAAAAABQ3WOITA6PL4TXXGE7UQRXKYRVLLSA)

After
![image](https://raw.githubusercontent.com/seng438-winter-2022/seng438-a4-Harsh-S7/main/media/afterDU.png?token=GHSAT0AAAAAABQ3WOISGEGN5ITYLGAZAYWAYRVLKEQ)

Explanation
Although the mutation coverage improved by 31% much higher than the required amount of 10%, we can see that there were still 68 mutations that had survived which should be removed in the next iteration.

Range
Before
![image](https://raw.githubusercontent.com/seng438-winter-2022/seng438-a4-Harsh-S7/main/media/beforeR.png?token=GHSAT0AAAAAABQ3WOIT4BGUALBHT6Y4H35OYRVLLYQ)

After
![image](https://raw.githubusercontent.com/seng438-winter-2022/seng438-a4-Harsh-S7/main/media/afterR.png?token=GHSAT0AAAAAABQ3WOISWUPT6G6ENBJQOLJ6YRVLLLA)

Explanation
The mutation coverage for the Range class was 69% before any changes and after the necessary changes had been implemented, the class went to 79% meeting the threshold of 10% but there were still 263 mutations that had survived.

# A discussion on the effect of equivalent mutants on mutation score accuracy
There were many equivalent methods that were injected into the code. For instance, dataUtilities had a for loop in the equals method(line 84) and the mutant that was injected we to replace the <= sign in with != in the end condition. This mutant was unhelpful when trying to find logical errors and made it difficult to increase coverage. No test case can account for equivalent mutations like this and nor should they as logically equivalent mutants don’t provide any benefit in finding issues with a program. The only thing that these mutants accomplish is giving developers a headache when trying to maximize their coverage. 

# A discussion of what could have been done to improve the mutation score of the test suites
The test scores although were improved heavily, an integral way to improve the mutation score was for us to understand which mutants were surviving and then create tests that could kill those mutants. This was especially necessary in the Range class, as the class was much larger than its counterpart and thus had more mutants which needed to be addressed. The remaining mutants were either not needed to cover as they were not harmful to the program or the mutants were created due to the operating system and are impossible to fix without a closer look at how the operating system is compiling the code.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing
Mutation testing allows programmers to evaluate the effectiveness of their test suites by injecting bugs into the SUT and running the test suite against each injected bug. Mutation testing catches many bugs in the SUT by creating new bugs to ensure that the test suite will catch as many faults as possible. Using mutation testing will result in test suites with higher coverage, because the programmer will add extra test cases to kill as many mutants as possible. Mutations can also reveal areas where the test suite is lacking. If many mutations on a particular method survive, that method likely wasn’t tested thoroughly enough. 
However, mutation testing is also time consuming and expensive. Designing different enough mutants can take a long time if it is done manually, and using an automated program can be expensive and still take time. Complex mutations can be difficult to implement and may have bugs themselves. Mutation testing also cannot be done with white-box testing, as knowledge of the source code is required to design mutants. 

# Explain your SELENUIM test case design process
The process for designing the Selenium test cases was basically based on the entire user experience. While designing the test case, the main focus was that since the web page we chose was an e-commerce website, there must be some key features which must be working well. These key features have to be the ones that both fulfill the purpose of the website as well as make sure that the user experience is not damaged.
So what we did is we selected basic functionalities such as Login, Store locator, Cart related operations and then tested them out. While designing the test case the main focus was how the web page handles different input i.e. what happens when a user interacts differently with the web page. For example, for the Login, we provided an incorrect password as a replacement to the correct one to see if the test case fails proving that while making a login attempt it does indeed check the password! Another example was to check if the product is added in the cart or not successfully when the “Add to Cart” button is pressed.

# Explain the use of assertions and checkpoints
The use of assertions(and in our case verifications) and checkpoints was to both ensure whether certain element, fields or text was present when a test case reaches a certain point as well as catch if a certain line was causing issue in the running of the test. For example, in the test case for Login, what we did is we made sure if the fields for username and password were present before they were filled by the Selenium IDE. In another example, where a checkpoint was used to debug the problem was the Add to Cart test. When going through the test case one assertion that we placed was to make sure the item is added to cart by checking if the confirmation is shown on the screen or not. But the test case kept failing i.e. assertion kept failing despite the confirmation being shown on the screen. By placing a checkpoint before the assertion, we realized that the web-page was loading slower while the test was running faster. So we placed a wait instruction/command to let the element load and then check for the assertion.

# how did you test each functionaity with different test data
For each functionality we changed the test data. What we did was that we changed different products i.e.. clicked somewhere else to make sure that despite clicking anywhere else, as long as it is a product it is successfully added to the cart. Another thing we noticed was that when we repeated the test for adding to the cart, since the item was already added to the cart so it won’t add it again. These tests are not present in the file we are submitting as they were repetitive. Another thing we tried and experienced was that when we slowed down the test from the Test execution speed functionality it waited for the web-page to load more results (as the test was slowed down the web-page was loading completely) and since more or different product was present (this was also due to best buy changing and mixing the results of the search when the search was repeated), a different product was added to cart but nonetheless the product was successfully added to the cart.

# Discuss advantages and disadvantages of Selenium vs. Sikulix
Selenium and Sikulix are both free and open source. Selenium is used for testing web applications, while Sikulix can be used to test any GUI. This means that Sikulix has more applications, however, Siklulix is platform dependent, which means you have to set up different tests on different platforms. Selenium uses the HTML source code for webpages to run its tests and allows the user to automate tests, and then run several together. Sikulix can also be used to automate tests, but uses image recognition instead of webpage HTML, which is what allows it to be used for other GUIs as well. 

# How the team work/effort was divided and managed
In this lab we again split into pairs to work on the mutation testing. Shamis and Usman worked on the DataUtilities class while Harsh and Heidi worked on the Range class. After both pairs finished with their class, the pairs traded and went over each other's work to ensure that everything had been done correctly. This also made sure that everyone understood what had been done. 
Additionally, each group member created 2 tests for the Best Buy website with Selenium. Then we combined all of the test cases and went over them together. 


# Difficulties encountered, challenges overcome, and lessons learned
The group encountered several difficulties with the mutation testing portion of the lab. Several members had problems getting PIT working, and it took 10 minutes to run once they did. This meant completing the lab was time consuming. However, once everyone had PIT working, most of the lab went smoothly. 

# Comments/feedback on the lab itself
Through the lab we learned a lot about mutation testing and GUI testing. The detailed description of how to use PIT was appreciated, but some resources on what to look for when we had problems would have been very helpful. The Selenium resources were descriptive and allowed us to get our GUI testing done quickly. Overall, the lab was informative and allowed us to put what we learned in lecture into practice. 
