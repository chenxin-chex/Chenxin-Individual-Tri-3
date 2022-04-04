# Chenxin Individual Work (Tri 3)

### [Replit Link](https://replit.com/@chenxinNi/Chenxin-Individual-Tri-3#Main.java)
Showcases my replit work from Tech Talks and projects assigned by OO

**Table of Contents**
* TOC
{:toc}

## Week 3 (Sort algorithms)
### [Week 3 Review Ticket](https://github.com/dsblack0/stickers_for_charity/issues/34)
**Bubble Sort (in [BubbleSort.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/BubbleSort.java)):** Compares adjacent elements and swaps them if they are in the wrong number. Since the code uses two for loops that iterates through the list, big o notation for the worst case scenario would be O(n * n) = O(n^2).
![image](https://user-images.githubusercontent.com/55467785/161411460-a2048a66-ee22-4fcf-8afb-874bb1434b34.png)

* Average Compare: 366800
* Average Swap: 183895
* Average Time (nanoseconds): 1517102

**Selection Sort (in [SelectSort.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/SelectSort.java)):** Splits the list into a sorted array and unsorted array. Each time we iterate through the unsorted array, we find the minimum value and add it to the sorted array. Since in the worst case scenario the code iterates through the array n times (once again two for loops), big o notation is O(n * n) = O(n^2).

![image](https://user-images.githubusercontent.com/55467785/161411641-f9695d52-b114-4662-b888-c0b6fc2df75b.png)

* Average Compare: 366691
* Average Swap: 855
* Average Time: 674975

**Insertion Sort (in [InsertSort.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/InsertSort.java)):** Iterates through each element and compares it to the previous values until it is no longer smaller than the previous value. Since in the worst case scenario we iterate through the array n times, big o notation is also O(n * n) = O(n^2).

![image](https://user-images.githubusercontent.com/55467785/161411896-b155ed06-cd3b-4861-ad45-2603fb9ab1e0.png)

* Average Compare: 185624
* Average Swap: 184766
* Average Time: 581523

**Merge Sort (in [MergeSort.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/MergeSort.java)):** Recursively splits the array in two until each array contains one value, then compare and combine the smaller lists together until entire sorted list is recreated. Since the array is first divided then sorted, merge sort is a combination of binary and linear search, so big o notation for the worst case scenario is O(n * log n)

![image](https://user-images.githubusercontent.com/55467785/161412313-8cb07522-4916-4e2f-b430-db0568720d5a.png)

* Average Compare: 7284
* Average Swap: 7284
* Average Time: 127009

**Analytics:** By comparing the compare count, swap count, and time, merge sort is the best algorithm for large data sets because it has the lowest average for all of these statistics. Additionally, as shown by the graph, its big o notation of O(n * log n) is smaller than O(n^2) that the other algorithms have

![image](https://user-images.githubusercontent.com/55467785/161416086-08922050-bf08-4b36-894d-1672fc6ce264.png)


## Week 2 (Calculator function)
### [Week 2 Review Ticket](https://github.com/dsblack0/stickers_for_charity/issues/31)
**Challenge 1 (in [Calculator.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/Calculator.java)):** Code rpnToResult method to calculate expression from Reverse Polish Notation
![image](https://user-images.githubusercontent.com/55467785/159758977-cc09ea7e-4cae-46d9-b3b2-93063a072ec1.png)

Used for loop to iterate through rpn, and used if loops to perform operation on the top two entries in stack, then pushed answer back into stack. Only one entry would remain at the end of for loop, which was the final result.
![image](https://user-images.githubusercontent.com/55467785/159759356-a550a504-c3e9-4ed0-8c1c-c1b97b153ccc.png)

**Challenge 2 (also in [Calculator.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/Calculator.java)):** Code for a Power (^) operator. Power operator had more precedence than other operators
![image](https://user-images.githubusercontent.com/55467785/159759616-504784fc-7ea4-4c40-ba7a-708fc45f1306.png)

Also had to edit tokensToReversePolishNotation and rpnToResult method to include power operator

![image](https://user-images.githubusercontent.com/55467785/159759889-1a74d637-7a70-46bd-a140-8d885de48e4b.png)
![image](https://user-images.githubusercontent.com/55467785/159759966-f5134614-72aa-479f-9654-83d4014e9848.png)



## Week 1 (Stacks & Queues)
### [Week 1 Review Ticket](https://github.com/dsblack0/stickers_for_charity/issues/25)
**Challenge 1 (in [Queue.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/Queue.java)):** Wrote the delete method for queue by setting new head and connecting tail as node
![image](https://user-images.githubusercontent.com/55467785/159210357-d386662c-11a0-422a-8350-f6254b351abb.png)

Difficulty printing out the queues so I changed addList and coded deleteList in QueueManager
![image](https://user-images.githubusercontent.com/55467785/159210432-d663ba19-99bf-444e-8e99-8282b87164a4.png)

**Challenge 2 (in [Merge.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/Merge.java)):** Created merge method to combine and sort two queues
![image](https://user-images.githubusercontent.com/55467785/159210541-bc82d51d-ffb7-4b70-bdc3-6e977023f36e.png)

Difficulty merging the entire queue because next() method of QueueIterator skipped over data

**Challenge 3 (in [Stack.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/Stack.java)):** Created stack class that follows the last in first out principle with methods push and pop
![image](https://user-images.githubusercontent.com/55467785/159310977-d9a734b7-191a-4739-abbd-c4bc3ac9db84.png)

Difficulty testing the stack to reverse a queue (didn't finish in time)

## Week 0 (Data Structures)
### [Week 0 Review Ticket](https://github.com/dsblack0/stickers_for_charity/issues/7)
**Challenge 1 (in [Main.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/Main.java)):** Used Hashmap data structure in order to dynamically create and store options
![image](https://user-images.githubusercontent.com/55467785/157779995-8f406ebd-3960-4d6b-9cdf-80e657933eb1.png)

Used try and catch method in order to print "Please enter a number listed in the menu." instead of causing error if the input isn't in the menu.
![image](https://user-images.githubusercontent.com/55467785/157780152-1a89eac2-dab1-4117-9f7e-3e978c610a05.png)


**Challenge 2 (in [IntByReference.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/IntByReference.java)):** Java can only call by value for parameters in a method, but variable "value" can be changed since the method is called within the object a. For object b, parameter "what" has to be updated using a method in order to change the reference.
![image](https://user-images.githubusercontent.com/55467785/157780670-780ed04d-6741-4f2e-8564-3b29eabe281f.png)

toString() method returns the integer variable "value" as a String.

![image](https://user-images.githubusercontent.com/55467785/157780832-f088b41c-d207-473b-8071-6199aaf2c66c.png)


**Challenge 3 (in [Matrix.java](https://github.com/chenxin-chex/Chenxin-Individual-Tri-3/blob/main/Matrix.java)):** toString() method iterates over the 2d array using enhanced for loops in order to return the 2d array as a String
![image](https://user-images.githubusercontent.com/55467785/157781193-e37b078f-9e58-4958-926c-c1c7531a7b1a.png)
