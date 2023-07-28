# MediaVault

## Overview
MediaVault is an application that allows users to track consumed media, provide reviews, and receive personalized recommendations based on their preferred genres.

<img width="1000" alt="mediavault_explore_page" src="https://github.com/mayowaibi/MediaVault/assets/66337024/d73ad2c9-eb4d-4f90-80c4-1981a026f95a">


## Initializing & Resetting the Database
The MediaVault database must be initialized using MySQL before running the main application.

To initialize the database, run the **SETUP.sql** script (located in MediaVault/database) with the root MySQL user.

To reset the database, run the **RESET.sql** script (located in MediaVault/database) with the root MySQL user.
**Note**: This should only be done if the SETUP.sql script has been previously run.

## Running MediaVault
To run MediaVault, simply compile and run the **MediaVault.java** file located in MediaVault/src/userinterface.

## Switching to Stub
A stub database was also implemented for ease of testing. To switch over from the real DB to the stub DB, set the stub flag to true in MediaVault.java using the following line of code in the main method:
```
UseStub.setStubFlag(true);
```
