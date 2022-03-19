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


# Analysis of 10 Mutants of the Range class 

# Report all the statistics and the mutation score for each test class



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
