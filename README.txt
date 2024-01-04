    The initial goal of this project was to develop a
game where a flag or geographic shape was displayed to
the user where they would then guess what country it
was and recieve a score based on their answers. I could
not find a mass folder of geographical shapes, so I 
scrapped this aspect of the game. Although, I realized
that I have the capability to make a random quiz game
for any topic by providing a compatible csv and image
folder.
    I first created the flag dataset by using a handy 
excel feature that allows mass importing of flags.Then, 
I made the DataReader which simply pulls information from 
the dataset. After that I made the GUI and added all of 
the logic needed to make a basic randomized quiz game.
Later, I decided to add functionality for using more
datasets.

How the game operates:
 - the SetData class is used to choose a question dataset
 - the game can be ran by running the GUI class
 - the spinner starts at 10, but can be put between 1 and
   100000 for a total amount of questions when starting
   the quiz
 - option buttons can not be used after a quiz is
   completed or before it is started
 - the amount of correct answers out of questions 
   answered and remaining questions is displayed in the 
   top left
 - a new game can be started at any time
   