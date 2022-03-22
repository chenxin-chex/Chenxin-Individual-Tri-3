{% include navigation.html %}

# Tech Talk Notes

## TT2 (Calculator)

**Calculator class:** inputs a string with integers and operations, returns the product
 - Hashmap operators to do mathematical functions
 - Hashmap seperators to seperate functions

1. Tokenization: seperate string into tokens
2. Put into RPN: put numbers into list and operators into stack depending on precedence, first have to peek (PEMDAS)
3. If operator in stack has precedence procede to calculate
4. Calculate: put all numbers in list into stack, when you get an operator, pop 2 numbers from stack and calculate, then push back into stack


**toString method:** that has original expression, other expressions, and final result
 - tokenization: convert String into series of tokens
 - Reverse polish notation: language that computer understands with stacks

-----------------------------------------------------------------------------------------
### Plans
Potential questions: How to print out RPN whilst calculating it
1. Review Wikipedia page on the Reverse polish notation to understand it
2. Figure out how seperators are coded in calculator
3. Code the different parts of calculator

## TT1 (Linked Lists)
Linked lists, queus, stacks are fundamental data structures. Implements ...
 - Generic Type T: applicable to different objects. Can use multiple data types without multiple stacks and queus for each
 - Interable interface: enhanced for loop

**Queus:** are first in first out (FIFO): there is a head and tail pointer, where head stays constant and tail changes as things are added, but head changes and tail is constant as things are removed. Enqueu and Dequeu

![image](https://user-images.githubusercontent.com/55467785/158440836-8aa4104a-8454-48be-addc-58bb92281ac8.png)

**Stacks:** are last in first out (LIFO): use push and pop

![image](https://user-images.githubusercontent.com/55467785/158440882-92f22d2e-71fe-4727-aca2-6813bea1cc13.png)

**Linked lists:** Queus has a linked list. Data is the objects, the next node would be the next object. 
![image](https://user-images.githubusercontent.com/55467785/158439605-e4d6c6bf-2501-410b-985a-d7ef800e751a.png)

-------------------------------------------
### Plans
Potential questions: How are linked lists related to queus and stacks? What is the difference between hashmaps and linked lists?
1. Understand how queus use FIFO to add/delete objects
2. Learn how to use for each loops as a iterable

## TT0 (Data Structures)
### Paradigms
Paradigms are a strategy to be followed for writing software applications
 - **Imperative paradigms:** Uses statements to change a program's state. Imperative programs are built from procedures and a series of commands to perform a task.
 - **Object Oriented paradigms:** Uses classes as blueprints to make objects out of. These class structures can be reused, and Java follows OOP.

### Data Structures
Some common data structures that java uses to store information include: Array lists, hashmaps, and algorithms (such as recursion).

---------------------------------
### Plans
Potential questions: Why do we not use imperative paradigms in java? What is difference between dictionaries and hashmaps?
1. Figure out how to use hashmaps in menu
2. Figure out how to return a 2d array as a String
    - Hint: "/n" is a line break in a string
