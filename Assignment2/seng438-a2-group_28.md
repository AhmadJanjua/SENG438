**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: Group Number   28  |
|-----------------|
| Student 1 name:   Ahmad Janjua        |   
| Student 2 name:   Maxwell Kepler      |   
| Student 3 name:   Christopher Luk     |   
| Student 4 name:   Matthew Ho          | 

**Table of Contents**

[1 Introduction	](#introduction)

[2 Detailed description of unit test strategy	](#detailed-description-of-unit-test-strategy)

[3 Test cases developed	](#test-cases-developed)

[4 How the team work/effort was divided and managed](#how-the-team-workeffort-was-divided-and-managed)

[5 Difficulties encountered, challenges overcome, and lessons
learned	](#difficulties-encountered-challenges-overcome-and-lessons-learned)

[6 Comments/feedback on the lab itself	](#commentsfeedback-on-the-lab-itself)

# Introduction

In this lab, we were tasked with creating and implementing test cases based off of requirements outlined in Javadocs. Once we designed the cases for our selected methods, we implemented them in Eclipse. This lab taught us the basics of Eclipse, specifically using JAR files and JUnit testing together. As well, it familiarised us with creating partitions and equivalence class for our test cases.

# Detailed description of unit test strategy

// including the input partitions you have designed

# Test cases developed

| Package                      | Method                   | Set up description                                           | Case Description                                                                                                        | Pass/Fail                                                                                                                                                   |
|------------------------------|--------------------------|--------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| org.jfree.data.Range         | getLowerBound            | Inputs: -2,-1                                                | A test to find the lower bound of two negative numbers where one is greater than the other                              | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLowerBound            | Inputs: -1,-1                                                | A test to find the lower bound of two negatives numbers where the values are the same                                   | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLowerBound            | Inputs: -1,0                                                 | A test to find the lower bound of a negative number and a zero                                                          | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLowerBound            | Inputs: 0,0                                                  | A test to find the lower bound of two zeros                                                                             | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLowerBound            | Inputs: 0,1                                                  | A test to find the lower bound of a zero and a positive number                                                          | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLowerBound            | Inputs: 1,1                                                  | A test to find the lower bound of two positive numbers where the value is the same                                      | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLowerBound            | Inputs: 1,2                                                  | A test to find the lower bound of two positive numbers where one number is greater than the other                       | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLowerBound            | Inputs: -2,2                                                 | A test to find the lower bound of a negative and positive numbers                                                       | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: -2,-1                                                | A test to find the upper bound of two negative numbers where one is greater than the other                              | Fail                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: -1,-1                                                | A test to find the upper bound of two negatives numbers where the values are the same                                   | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: -1,-0                                                | A test to find the upper bound of a negative number and a zero                                                          | Fail                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: 0,0                                                  | A test to find the upper bound of two zeros                                                                             | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: 0,1                                                  | A test to find the upper bound of a zero and a positive number                                                          | Fail                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: 1,1                                                  | A test to find the upper bound of two positive numbers where the value is the same                                      | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: 1,2                                                  | A test to find the upper bound of two positive numbers where one number is greater than the other                       | Fail                                                                                                                                                        |
| org.jfree.data.Range         | getUpperBound            | Inputs: -2,2                                                 | A test to find the upper bound of a negative and positive numbers                                                       | Fail                                                                                                                                                        |
| org.jfree.data.Range         | toString                 | Inputs: -2,-1                                                | A case to test how two negatives would be displayed as a string.                                                        | Fail: The prediction is the minimum and maximum of range. Correctly displays maximum range but not minimum.                                                 |
| org.jfree.data.Range         | toString                 | Inputs: -1,-1                                                | A case to test how two negatives would be displayed as a string if they are equivalent.                                 | Pass                                                                                                                                                        |
| org.jfree.data.Range         | toString                 | Inputs: -1, 0                                                | A case to test how a negative and a zero would be displayed as a string.                                                | Fail: Max range is correctly represented, but lower range is incorrectly represented.                                                                       |
| org.jfree.data.Range         | toString                 | Inputs: 0,0                                                  | A case to test how two zeros would be displayed as a string.                                                            | Pass                                                                                                                                                        |
| org.jfree.data.Range         | toString                 | Inputs: 0,1                                                  | The case checks the display of zero and a positive number.                                                              | Fail: Lower range is incorrectly represented. Upper range is correctly represented.                                                                         |
| org.jfree.data.Range         | toString                 | Inputs: 1,1                                                  | The case tests the display of the content when both numbers are positive and equivalent.                                | Pass                                                                                                                                                        |
| org.jfree.data.Range         | toString                 | Inputs: 1,2                                                  | The case tests the display of two different positive numbers.                                                           | Fail: Like other tests for toString(). Correct upper with incorrect lower range.                                                                            |
| org.jfree.data.Range         | toString                 | Inputs: -2,2                                                 | The case tests the result from displaying a positive and negative number.                                               | Fail: Same as other toString() tests. The patterns indicate that the lower range is not being shown, alternatively the average is being shown in its place. |
| org.jfree.data.Range         | getLength                | Inputs: -2,-1                                                | This tests the result from getting the length for two different negative numbers.                                       | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLength                | Inputs: -1,-1                                                | This tests the result from getting the length for two identical negative numbers.                                       | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLength                | Inputs: -1, 0                                                | This tests the result from getting the length for zero and a negative number.                                           | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLength                | Inputs: 0,0                                                  | This tests the result from getting the length for two zeros.                                                            | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLength                | Inputs: 0,1                                                  | This tests the result from getting the length for zero and a positive number.                                           | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLength                | Inputs: 1,1                                                  | This tests the result from getting the length for two identical positive numbers.                                       | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLength                | Inputs: 1,2                                                  | This tests the result from getting the length for two different positive numbers.                                       | Pass                                                                                                                                                        |
| org.jfree.data.Range         | getLength                | Inputs: -2,2                                                 | This tests the result from getting the length for a negative and positive number.                                       | Pass                                                                                                                                                        |
| org.jfree.data.Range         | contains                 | Inputs -2, 2                                                 | A case to test standard and basic positive range values of the method contains.                                         | Pass                                                                                                                                                        |
| org.jfree.data.Range         | contains                 | Inputs -2, 1                                                 | A case to test standard and basic negative range values of the method contains.                                         | Pass                                                                                                                                                        |
| org.jfree.data.Range         | contains                 | Inputs 0, 0                                                  | A case to test a small range where the range is just one number.                                                        | Pass                                                                                                                                                        |
| org.jfree.data.Range         | contains                 | Inputs -100000000, 100000000                                 | A case to test a Huge range where the range spans millions.                                                             | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | getCumulativePercentages | Input: Test on Pair: {<0,5>,<1,9>,<2,2>}                     | This case checks to see if the method correctly creates the cumulative percentage key value pairs.                      | Fail: None of the percentiles are not being correctly determined.                                                                                           |
| org.jfree.data.DataUtilities | getCumulativePercentages | Input Pair: {<0,5>}                                          | The case test to check accurate calculation on a single key/value pair.                                                 | Fail: The predicted key/value pair is incorrectly determined.                                                                                               |
| org.jfree.data.DataUtilities | getCumulativePercentages | Input Pair: {}                                               | The case tests when a valid object of no key/values is passed to the object.                                            | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | getCumulativePercentages | Input Pair: null                                             | The case tests when an invalid parameter is placed as the argument.                                                     | Fail: The exception thrown is not the expected exception.                                                                                                   |
| org.jfree.data.DataUtilities | getCumulativePercentages | Input Pair: {<1,”1”>}                                        | The case tests if an invalid object causes an exception to be thrown.                                                   | Fail: The exception thrown is not the correct exception.                                                                                                    |
| org.jfree.data.DataUtilities | calculateColumnTotal     | Values2D: {{1, 8}, {1, 2.5}} Column: 1                       | This tests if the column’s total is calculated correctly for valid data                                                 | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | calculateColumnTotal     | Values2D: {null, 7} Column: 0                                | This tests if the total is calculated correctly for data containing a null value.                                       | Fail: it assigned a value of 1 to null                                                                                                                      |
| org.jfree.data.DataUtilities | calculateColumnTotal     | Column: -1                                                   | This tests if the correct error is thrown when accessing an index out of bounds.                                        | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | calculateColumnTotal     | Values2D: null Column: 0                                     | This tests if the correct error is thrown when passed an invalid data object.                                           | Fail: The exception thrown is not the expected exception.                                                                                                   |
| org.jfree.data.DataUtilities | calculateRowTotal        | Values2D: {{1, 8}, {1.6, 2.5}} Row: 1                        | This tests if the row’s total is calculated correctly for valid data                                                    | Fail: returns the value in the first index.                                                                                                                 |
| org.jfree.data.DataUtilities | calculateRowTotal        | Values2D: {null, 7} Row: 0                                   | This tests if the total is calculated correctly for data containing a null value.                                       | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | calculateRowTotal        | Row: -1                                                      | This tests if the correct error is thrown when accessing an index out of bounds.                                        | Fail: The exception thrown is not the expected exception.                                                                                                   |
| org.jfree.data.DataUtilities | createNumberArray2D      | Inputs ((1.0,2.0,3.0),(3.0,2.0,1.0)) Rows: 2 Columns:3       | A case to test the basic functionality of creating a 2D array using just positive values.                               | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray2D      | Inputs ((-1.0,-2.0,-3.0),(-3.0,-2.0,-1.0)) Rows: 2 Columns:3 | A case to test the basic functionality of creating a 2D array using just Negative values.                               | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray2D      | Inputs ((1.0,2.0,3.0),(3.0))                                 | A case to test an uneven creation of a 2D array. Where the first row has 3 values and the second row has 1 value.       | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray2D      | Inputs: (()()) Rows: 0 Columns: 0                            | A case to test an empty creation of a 2D array. Where the value is just an empty 2D array.                              | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray2D      | Inputs: null                                                 | A case to test if the right exception is thrown when a null value is added. Should throw an illegal argument exception. | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray2D      | Inputs ((1.0,2.0,3.0),(3.0,2.0,1.0)) Rows: 2 Columns:3       | A basic mocking test to create a multiple row and multiple column array.                                                | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{1.0,2.0,3.0}                                         | A test to see if createNumberArray would create an array with positive inputs.                                          | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{-1.0,-2.0,-3.0}                                      | A test to see if createNumberArray would create an array with negative inputs.                                          | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{0.0,00.0,0.0}                                        | A test to see if createNumberArray would create an array with zeros.                                                    | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{1.0,-1.0}                                            | A test to see if createNumberArray would create an array with positive and negative inputs.                             | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{}                                                    | A test to see if createNumberArray would create an empty array with no inputs.                                          | Pass                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{1.0,2.0,3.0,4.0,5.0}                                 | A test with mocking to see if createNumberArray would create an array with positive inputs.                             | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{-1.0,-2.0,-3.0,-4.0,-5.0}                            | A test with mocking to see if createNumberArray would create an array with negative inputs.                             | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{-1.0,2.0,-3.0,4.0,-5.0}                              | A test to see if createNumberArray would create an array with positive and negative inputs.                             | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{-1.0,2.0,-3.0,4.0,-0.0}                              | A test to see if createNumberArray would create an array with positive inputs, negative inputs and a zero input..       | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{0.0,0.0,0.0,0.0,0.0}                                 | A test with mocking to see if createNumberArray would create an array with zeros.                                       | Fail                                                                                                                                                        |
| org.jfree.data.DataUtilities | createNumberArray        | Inputs:{}                                                    | A test with mocking to see if createNumberArray would create an empty array with no inputs.                             | Pass                                                                                                                                                        |

# How the team work/effort was divided and managed
The team work was divided as much as possible to the best of our abilities. Due to how there were five tests from either Range or DataUtiltiltes, one different person had to do two tests such that all of the tests were done. Although work was not perfectly divided, it was done voluntarily and was not an issue amongst all the members of the team. The team used an online group chat to maintain constant communication throughout the project. This allowed team members to share their ideas and ask questions, as well as hold discussions on any important topics that needed attention. The chat helped keep everyone informed and on the same page, and quickly addressed any issues that arose. The team's method of combining division of tasks, and effective communication was well organised, efficient, and successful, leading to the successful completion of the project.

# Difficulties encountered, challenges overcome, and lessons learned

Text…

# Comments/feedback on the lab itself
As participants of the lab, we found that it was well-designed and provided us with clear expectations of what was expected from us. The lab was not only educational, but also enjoyable and engaging, allowing us to learn about mocking and testing strategies through hands-on experience. The instructions were straightforward and easy to follow, making it much better than the previous lab we had done. We feel that this lab was a valuable opportunity for us to gain a deeper understanding of these crucial topics in software development. We came away from the lab feeling more confident and equipped to tackle these challenges in our future projects. As participants of the lab, we were thrilled to have the opportunity to work with JUnit and put our testing and mocking skills to the test. It was a great experience to get hands-on with this software, as we don't often have the opportunity to use it in our day-to-day work. 