# example_roulette
Refactored by Brandon Ho and Daniel Pak

Program to refactor that plays a game of roulette

Refactored 9/10/2015

#Adding a new feature
Add a new subclass of Bet and add that to the array of classes. Edit the subclass
to have different features compared to the other subclasses. 

#In what ways is the refactored code simpler?
If statements were removed, resulting in certain methods that only returned
single statements. 
#In what ways is the refactored code more complex?
Have to go through multiple subclasses to get all the information instead of it all being in one class (Game). 
#What trade-offs did you make when refactoring your old code?
Made the new code slightly harder to navigate because we have to look through all the subclasses to get the details, but the new code is more flexible and does not have as many hard-coded statements. 
#Which code do you prefer and why?
Prefer the refactored code because it has more concise classes and not as many extra if statements. The new code is also much more flexible so if you want to add a new feature you do not have to add to if-statements. Instead, you can just add to the class, which is much more organized. 