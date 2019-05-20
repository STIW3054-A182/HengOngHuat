# HengOngHuat-Repo

# 1. Group Info
| NO |      NAME      | MATRIC NO | POSITION |
|:--:|:--------------:|:---------:|:--------:|
|  1 | Cheang Shy Yah |   252823  |  Leader  |
|  2 | Ling Zhong Li  |   252931  |  Member  |
|  3 | Lim Xin Yi     |   253982  |  Member  |
|  4 | Chong Mei Yong |   254459  |  Member  |
|  5 | Liew Sin Hui   |   254716  |  Member  |
|  6 | Tan Yu Jia     |   255045  |  Member  |


# 2. Introduction
We are required to develop a real-time system using the Java programming language (Maven).
The system should be able to:
- Check URLs
- Count the number of players
- Display statistics
- Display all players from KEDAH
- Display all TOP 3 players from each category
- Count the winning points
- Display a player result


# 3. Table of Contents
| NO | CLASS                  | DESCRIPTION                                                                                                                                         | LINK                                                                                                                             |
|----|------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| 1  | MainClass              | This class is to call the six thread and the run() method will internally to execute it with their own thread.                                      | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/MainClass.java)              |
| 2  | CheckUrls              | This class is to identify the link. If the link is invalid and the validating process takes more than 1 minute, that link will store in log file.   | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/CheckUrls.java)              |
| 3  | CheckValidTable        | This class is to identify the link that contain the table information.                                                                              | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/CheckValidTable.java)        |
| 4  | ValidLink              | This class is to print out valid link and store all the valid link by using an array.                                                               | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ValidLink.java)              |
| 5  | ValidTableLink         | This class is to store all the valid link that contain the table information.                                                                       | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ValidTableLink.java)         |
| 6  | CountPlayer            | This class is to get the certain informations that we want by using JSOUP and print out the subtotal of players for each category.                  | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/CountPlayer.java)            |
| 7  | ResultCountPlayer      | This class provides method to monitor the task in CountPlayer class that executed by callable.                                                      | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ResultCountPlayer.java)      |
| 8  | GetStateData           | This class is to get the certain informations that we want by using JSOUP and store it by pair method.                                              | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/GetStateData.java)           |
| 9  | ResultStateStatistic   | This class will print out the number of players for each state by category.                                                                         | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ResultStateStatistic.java)   |
| 10 | CalculationState       | This class is to calculate the subtotal of players for each state by category and also the grand total of players for each state and each category. | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/CalculationState.java)       |
| 11 | KedahPlayers           | This class is to get the certain informations that we want by using KEYWORD from the properties file.                                               | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/KedahPlayers.java)           |
| 12 | ResultKedahPlayer      | This class provides method to monitor the task in KedahPlayers class that executed by callable.                                                     | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ResultKedahPlayer.java)      |
| 13 | Top3Players            | This class is to get the certain informations that we want by using KEYWORD from the properties file.                                               | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/Top3Players.java)            |
| 14 | ResultTop3Player       | This class provides method to monitor the task in Top3Players class that executed by callable.                                                      | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ResultTop3Player.java)       |
| 15 | GetPointerData         | This class is to get the certain informations that we want by using JSOUP and store it by pair method.                                              | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/GetPointerData.java)         |
| 16 | ResultPointerStatistic | This class will print out the points for each state by category.                                                                                    | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ResultPointerStatistic.java) |
| 17 | CalculationPoints      | This class is to calculate the subtotal of points for each state by category and also the grand total of points for each state and each category.   | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/CalculationPoints.java)      |
| 18 | NamePlayer             | This class is to get the certain informations that we want by using KEYWORD from the properties file.                                               | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/NamePlayer.java)             |
| 19 | ResultNamePlayer       | This class provides method to monitor the task in NamePlayer class that executed by callable.                                                       | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/ResultNamePlayer.java)       |
| 20 | PropertyFileWriting    | This class is to set the keys and values.                                                                                                           | [view](https://github.com/STIW3054-A182/HengOngHuat-Repo/blob/master/src/main/java/com/groupProject/PropertyFileWriting.java)    |
