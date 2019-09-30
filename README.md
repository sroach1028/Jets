### Weekend Project 3

"Jets on the Airfield"
created by Shaun Roach
at Skill Distillery, Denver, CO

## Project Overview

This program reads in a file of comma-separated lines containing information on various military planes; including fighter jets, cargo planes, bomber jets and unmanned drones.
The program stores each plane from the read-in file onto the "airfield", and provides the user with various options.
The user is capable of adding and removing planes from the airfield.
The user may command each jet to perform its specialized function.
The user may view the fastest plane on the airfield.
The user may view the jet with the greatest range.


## Technologies

This program is written in Java with Eclipse IDE. It includes an abstract superclass and numerous subclasses implementing interfaces to design airplanes with unique characteristics specific to their type (Fighter, Bomber, Cargo, UAV,). In the Java code are instances of String Arrays, and wrappers and parsing to convert the String values from the .txt file into primitive values for use in the program. 

## Lessons Learned

The most valuable lesson gained from developing this project was the value of the debugging tool in Eclipse. I was encountering difficulties when reading from the exterior file and translating the text into data for the program. Using the debugging tool allowed me to realize the file reader will read blank lines and attempt translating them into data anyway, causing a run-time exception.
