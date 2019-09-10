# Rowdy Racers Skeleton

With this skeleton, the basic setup for the Rowdy Racers project - with already some basic functionality is completely done.

You can use it as the starting point of your own Rowdy Racers application.

## Usage

You launch the application by executing the `main` method fo the `RowdyRacersApplication` class.
- You can move the Red player to the East or South by clicking the corresponding buttons (the bounds of the Grid will
already be respected).

## Architecture

The project is divided into 2 distinct parts:

1. The **domain**
    - Which resides in the `com.switchfully.project.rowdyracers.domain` package.
2. The **GUI**
    - Which resides in the `com.switchfully.project.rowdyracers.gui` package.

_And, as a third part: the `RowdyRacersApplication` class which instantiates and launches the application._
    
### Domain

The domain is the representation (model) of the actual business domain of Rowdy Racers:

- The domain contains all the domain objects such as `Game`, `Grid`, `Square`, `Player`,...
- The domain should contain all the business rules and functional requirements of Rowdy Racers. This means that all 
the rules that make Rowdy Racers the game it is should be implemented in the domain, NOT in the GUI.
- Never, ever, should any GUI code (e.g. any class from `java.awt` or `javax.swing` or `javafx`) be used in the domain. 
Our domain should be pure and completely independent from any GUI library / framework used!
    - Our domain is (G)UI framework agnostic, we can rather quickly use our domain in a different GUI than the current. 

When working with this skeleton, it is important you remember - and adhere to - these rules.
- Otherwise, before you known it, your domain is tightly coupled with your GUI. Making it very difficult to keep a clear 
overview of what is happening where, updates to the GUI might impact the domain, replacing the GUI with 
another technology becomes difficult and a lot of work,...  

### GUI

The current GUI (located inside of `com.switchfully.project.rowdyracers.gui`) is implemented using **Java Swing**.

- The GUI elements use the domain objects and their data to provide visual representation in the GUI of these domain objects.
    - E.g.: A `Player` (from the domain) is represented by a `PlayerGE` (GraphicalElement) which draws the player as an image
    of a car. 
- The GUI should be as **dumb as possible**, meaning it should not implement any of the rules of Rowdy Racers. It should
always delegate that responsibility to the domain objects.

You are perfectly free to drop this GUI for a new GUI (e.g. a GUI written with JavaFX instead of Swing (`JavaFX > Swing`)).
- How? Create a new package `com.switchfully.project.rowdyracers.guifx` in which you build your own GUI classes and 
objects using JavaFX. Then, change to `RowdyRacersApplication` so that it uses your new GUI instead of the old.
    - Because of our architecture / design, you will have to change nothing to your domain, nor will you have to 
    reimplement any existing business rules (as they are also part of your domain and not your GUI).

### RowdyRacersApplication

It creates the initial domain objects, creates the GUI windows (with panels,...), it launches the window 
and starts the game.
