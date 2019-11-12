A command line application for parking lot.

The Parking Lot consists of N levels.

Each Parking Level consists of:
1) M number of sections.
2) Any number of parking spots.
3) Vehicles restricted to different types.

A vehicle can be parked to the spot closest to the entry. 
So the vehicles are parked in the fashion for level 1 as an example :

1) First -> Level 1, section 1 spot 1, 
2) Second -> Level 1 , section 2 spot 1,
3) Third -> Level 1, section 1 spot 2.

And so on...

Example of input to the Application:

	Enter the number of Parking levels 
	3
	Please Enter LevelNumber NumberOfSections VehiclesSeperatedByComma
	1 2 Bus,Truck
	Enter the section sizes
	Section 1:  
	8
	Section 2:  
	10
	----------------------------------------------------------------------------
	Please Enter LevelNumber NumberOfSections VehiclesSeperatedByComma
	2 3 Bike,Car
	Enter the section sizes
	Section 1:  
	5
	Section 2:  
	3
	Section 3:  
	7
	----------------------------------------------------------------------------
	Please Enter LevelNumber NumberOfSections VehiclesSeperatedByComma
	3 1 Car
	Enter the section sizes
	Section 1:  
	10
	----------------------------------------------------------------------------
	Please Provide an input for entry,exit or quit
	Entry Car TS07EH3768
	Please proceed to Level 2, Section 1 Spot 1
	----------------------------------------------------------------------------
	Please Provide an input for entry,exit or quit
	Entry Car TS07EH3769
	Please proceed to Level 2, Section 2 Spot 1
	----------------------------------------------------------------------------
	Please Provide an input for entry,exit or quit
	Exit TS07EH3768
	Level 2, Section 1 Spot 1 is now available
	----------------------------------------------------------------------------
	Please Provide an input for entry,exit or quit
	Entry Bike TS07EH3790
	Please proceed to Level 2, Section 1 Spot 1
	----------------------------------------------------------------------------
	Please Provide an input for entry,exit or quit
	quit

