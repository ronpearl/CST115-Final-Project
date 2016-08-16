# CST115 Final Project - Vending Machine

#### Program:
Vending Machine
#### Authors:
Ronald Pearl, Aaron Fonseca, Kris Hayes
#### Summary:
Final Project for CST-115 class
#### Date:
8/8/16 - 9/25/16
#### Description:
The vending machine will have two types of users – a customer, who will be able to select a product, and a BOSS, who will be able to maintain the collection of products in the machine.  The machine itself will have a graphical interface that displays the available products and allows the user to make selections.  The BOSS will have a separate interface that provides a variety of maintenance options.  The machine will provide a means of alternating between the two types of users.

## Milestone 1

1. Sketch a storyboard of end product that shows the flow of the application (e.g., user input, application output).

2. Design a class using UML that models a product one might find in a snack machine. Submit UML for their product class. Submit a document with your UML.

3. Design a class using UML that models a dispenser of products. Students should submit UML for their dispenser class. Submit your UML as a document. 

## Milestone 2

Part 1:  Design an inheritance hierarchy using UML

Create and submit a design document that includes a UML for the following class hierarchy:

1. Product class

2. Drink class and Snack class (sub-classes of Product)

3. Candy class, Chips class and Gum class (sub-classes of Snack)

Your diagram should be developed using a tool such as Visio or MS Word and should illustrate the relationship between the classes.  

Make sure that all classes include the following:
1. No argument constructor

2. Overloaded constructor that initializes the fields with the parameters

3. Overloaded copy constructor that initializes the fields with a copy of another object’s fields

4. A toString() method

You should add other methods you think are relevant to your class.

Part 2:  Implementing the classes

Using your UML, write the code to implement the following classes:

1. Product (make this class abstract)

2. Snack (make this class abstract)

3. Drink

4. Candy

5. Chips

6. Gum

7. Dispenser (add a constructor that populates the Dispenser class array with a variety of Products)

8. Finally, write a main method that creates a Dispenser and calls the Dispenser method displayProducts().

Submit all your files as one project, which includes the main() method and all classes.


## Files

Storyboard is located in the Storyboard folder.
Product and Dispenser classes and their UMLs are in the Final_Project package.
