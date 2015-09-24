This folder contains the java classes that are used for building the visualization framework.
In particular, "medicalsignalrepresentation" is the main project package and it contains the following classes:
- PredictionModel: Main class of the project. It is in charge of running the main frame that contains the visualization panel.
When running the project it is not necessary to pass any command line parameters.

- CartesianFrame: This class is in charge of configuring the main container. It sets the principal characteristics of each physiological signal (i.e. The minimum and maximum values a signal can achieve). If the dataset changes it is necessary to modify the signal characteristics accordingly to the new dataset (panel.setAxes(...) method).

- BigPanel: This class is in charge of containing all the individual panels. It is used for set the preferred size of the main panel each time a change occurs (signal selection/deselection, new data is included, ...).

- CartesianPanel: This class contains the panel where the graphics will be displayed. It is in charge of updating the graphics each certain amount of time in order to include new data into the visualization window.