>   **SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#1 – Introduction to Testing and Defect Tracking**

| Group: Group Number   28  |
|-----------------|
| Student 1 name:   Ahmad Janjua        |   
| Student 2 name:   Maxwell Kepler      |   
| Student 3 name:   Christopher Luk     |   
| Student 4 name:   Matthew Ho          |  
test commit


**Table of Contents**

(When you finish writing, update the following list using right click, then
“Update Field”)

[1 Introduction	](#introduction)

[2 High-level description of the exploratory testing plan	](#high-level-description-of-the-exploratory-testing-plan)

[3 Comparison of exploratory and manual functional testing	](#comparison-of-exploratory-and-manual-functional-testing)

[4 Notes and discussion of the peer reviews of defect reports	](#notes-and-discussion-of-the-peer-reviews-of-defect-reports)

[5 How the pair testing was managed and team work/effort was
divided	](#how-the-pair-testing-was-managed-and-team-workeffort-was-divided)

[6 Difficulties encountered, challenges overcome, and lessons
learned	](#difficulties-encountered-challenges-overcome-and-lessons-learned)

[7 Comments/feedback on the lab and lab document itself	](#commentsfeedback-on-the-lab-and-lab-document-itself)

# Introduction

In the lab, we worked on testing a system for its functionality. The system under test (SUT) was an ATM, which was to be used by customers, operators, and a bank. The idea was to try different methods of testing that we learned in class without knowing the underlying implementation of the ATM. The lab also subdivided the group into pairs to help familiarize the team with roles in development. The first method the group performed was exploratory testing, which was done in pairs of two. Exploratory testing is where individuals test a system as they wish, identifying design aspects from the requirements and testing them as they come across them. There is no heavy planning involved, just a general objective. The next method used to test the system was manual scripted testing. Manual scripted tests are tests that are written beforehand and then implemented by the tester. In our case, the tests were provided to us, and we tested all the given functionalities. Lastly, the method tested was regression testing, which is done on newer versions to see if bugs were resolved or were still in progress. The group did regression on the manual scripted tests. Overall, the lab was about the group working together and testing an ATM system using exploratory tests, manual scripted tests, and regression.

# High-level description of the exploratory testing plan

Testing Pair #2 - Max and Christopher’s Plan: To perform our exploratory testing plan, we first covered the requirements for the ATM simulation found in Appendix B. Our group decided to take the approach of testing a few functions extensively, and to test both the common and exceptional paths. Based on their requirements, we ended up thoroughly testing the ATM card and PIN validation, transfers, account inquiry, and system startup functions.
To test the ATM card and PIN validation, we chose tests that would work with and against the following requirements:
- A customer will be required to insert an ATM card and enter a Personal Identification Number (PIN) - both of which will be sent to the bank for validation as part of each transaction.
- If the bank determines that the customer's PIN is invalid, the customer will be required to re-enter the PIN before a transaction can proceed. If the customer is unable to successfully enter the PIN after three tries, the card will be permanently retained by the machine, and the customer will have to contact the bank to get it back.
To test the transfer functions, we chose tests that would test the following requirements:
- A customer must be able to make a transfer of money between any two accounts linked to the card.
To test the account inquiry functions, we focused on testing the following requirement:
- A customer must be able to make a balance inquiry of any account linked to the card.
To test the system startup functions of the ATM simulation, we chose to test the following requirements:
- After turning the switch to the "on" position, the operator will be required to verify and enter the total cash on hand.


# Comparison of exploratory and manual functional testing

Exploratory and manual functional testing are both methods of testing software to ensure that it functions as intended. However, they differ in their approach and goals.

Exploratory testing is a testing method where tests are designed and executed at the same time. Although they are unscripted in nature, that does not mean that the testers are unprepared. They first thoroughly study the requirements of the software, to gain an understanding of how the software should work. Then, in this case, we divided our group into pairs, where each took a vastly different approach to testing the program. Pair one’s method was to test several different functions while taking common paths, while pair two focused more on testing a few functions extensively with both general and exceptional paths. Once both groups finished testing, we reviewed each other's work, finding similarities and differences between our findings. It was interesting to see where our thought patterns overlapped, and where we differed greatly. Because of the differences in our methods, we were able to uncover more bugs in the software, which tends to be a benefit of this testing method. 

Manual function testing, on the other hand, is a more structured and formal testing method. It involves following a predetermined test plan and test cases to ensure that the software meets its functional requirements. The focus is on verifying that the software behaves as specified in the requirements. This method had our group divide back up into teams of two, where one student operated the software, running the tests, while the other took note of their results. After completing the tests, we regrouped to review the work to ensure the results made sense and were reliable. By having systematic testing, a key benefit of this method of testing is the efficiency and speed found by running created tests. 

During the testing process, we first recorded our findings in a spreadsheet before converting them over to a Jira project. In the process, we found that we had already tested 5 out of the 40 manual scripted tests, while having 7 out of the remaining 16 exploratory tests turned out to be quite similar to existing MST tests. Although it's intriguing to see where the similarities lie, it also goes to show a clear tradeoff of how the free flowing nature of exploratory testing uncovered bugs that wouldn’t have been found through a more systematic approach. While the effectiveness of exploratory testing would appear to be finding unconventional bugs and fast development in a team, the effectiveness of manual scripted testing lies in the flexibility testers have while performing their tests. Research into these testing methods show that exploratory testing found significantly more defects than manual scripted testing, leading to that method being more efficient.

# Notes and discussion of the peer reviews of defect reports

After conducting peer reviews of the defect reports, some similarities and differences were identified. One similarity was that some of the tests were the same across the two teams. They tested the same functionality with the same edge cases. This was beneficial in validating the legitimacy of the tests across the pairs. It improved the ability to cross reference those specific tests. Another similarity found was that some tests tested the same functionality, but on different edge cases. This provided the benefit that the functionality was more thoroughly tested, but at the cost of using up more resources and increasing the redundancy. This is not desirable because that means much time and resources are spent on one object, when it would benefit from distributing the resource on other tests. 
A benefit of the peer reviews on the defect reports was reflected upon the clarity of the reports produced by each group. It made it easy to check if the report written was understandable to a person who did not write the bug report. It gave us the ability to select the best and most beneficial content to include in the defect report and reject information that would otherwise be of no substance. However, there was a  downside to the pair oriented process. Merging, ensuring there were no duplicates and standardizing the two teams' work required time and effort. This method was good for individuals learning the methodology of writing defect reports, but is not efficient for those that have experience. Overall the peer reviews of the defect report gave insight and clarity on how to construct and effectively write effective defect reports.

# How the pair testing was managed and team work/effort was divided 

The pair testing for this project was managed in a randomized fashion as it was the first time that the team was working together. This approach allowed for a fair distribution of tasks and ensured that everyone had an opportunity to work with different team members. In addition, teamwork and effort was divided as equitably as possible, with each team member being given the opportunity to work on tasks that they specialized in and felt most comfortable with. This approach ensured that everyone had the opportunity to utilize their strengths and contribute to the project in a meaningful way. To ensure that the pair testing was conducted effectively, the team established clear protocols and guidelines for testing and reporting results, which helped to streamline the process and ensure consistency. Furthermore, the team held regular meetings to discuss progress, share feedback, and make any necessary adjustments to the testing strategy. To facilitate continuous communication, the team also utilized an online group chat that allowed team members to voice their thoughts and ask questions, as well as have discussions on any matters that required attention. This helped to ensure that everyone was on the same page and any issues were addressed in a timely manner, which contributed to the overall success of the project. Overall, the team's approach to pair testing, division of effort, and communication was well-coordinated, efficient, and effective, which helped to ensure that the project was completed successfully.

# Difficulties encountered, challenges overcome, and lessons learned

Within the course of the assignment, it was initially confusing due to the unfamiliarity of working with a new group of people and a program that required experimentation to learn, presented a number of difficulties and challenges. One of the main difficulties encountered was not knowing anyone in the group and trying to establish effective communication and collaboration. Additionally, working with a program that none of us were familiar with, proved to be a challenge as it required a lot of experimentation and trial and error to learn how to use it effectively. Another challenge was not knowing how to use JIRA, which is a tool that was integral to the project, but required additional learning and effort to master. Despite these difficulties, the team was able to overcome them through persistence, communication, and a willingness to learn and experiment. Ultimately, this assignment taught us valuable lessons about the importance of effective communication, the benefits of experimentation and learning, and the power of persistence in the face of challenges.

# Comments/feedback on the lab and lab document itself

The lab in question was found to be quite effective as an ice breaker for the team, as it provided an opportunity for team members to work together for the first time and get to know one another. The lab itself was well-designed, providing an appropriate level of complexity and engagement for the group. The simplicity of the lab allowed for everyone to understand the task at hand and work together effectively, however, it also provided enough work to keep everyone occupied and engaged throughout the duration of the lab, even though it could be considered tedious, but it was also engaging.
One of the main challenges encountered during the lab was the use of JIRA. Due to the lack of prior knowledge and understanding of the purpose and functionality of JIRA, the team initially struggled to navigate and utilize the tool effectively. This presented a significant challenge for the team, as JIRA was an integral part of the project, and its proper use was crucial to the success of the lab. Despite this, the team was able to overcome this challenge through persistence, communication, and a willingness to learn and experiment.
In terms of the lab document itself, it provided clear instructions and guidelines for conducting the lab, and was well-organized and easy to follow. However, the team did mention that they found it hard to understand the purpose of JIRA without any prior knowledge or understanding.
Overall, the lab was a positive experience for the team and provided a valuable opportunity for team members to work together and learn from one another. The challenges encountered during the lab served as valuable learning experiences that helped to strengthen the team's ability to work together effectively.

