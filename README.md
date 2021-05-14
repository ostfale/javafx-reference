# FXTest

This reference JavaFX Client has been created from https://start.gluon.io and got some convenience functions for fxml 
handling (controller/ handler)



## Links

+ Start gluon project: https://start.gluon.io
+ Basic requirements: https://docs.gluonhq.com/client/#_requirements

## Quick instructions

### Run the sample

    mvn javafx:run

### Run the sample as a native image

    mvn client:build client:run

### Run the sample as a native android image

    mvn -Pandroid client:build client:package client:install client:run

### Run the sample as a native iOS image

    mvn -Pios client:build client:package client:install client:run

## Selected features

This is a list of all the features that were selected when creating the sample:

### JavaFX 16 Modules

 - javafx-base
 - javafx-graphics
 - javafx-controls
 - javafx-fxml
