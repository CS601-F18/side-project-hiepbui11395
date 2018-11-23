### Gamer Portal
Gamer portal is a page for gamer to find and connect with others who have the same favorite and time.

### Part 1 - System Design
The web application will be implemented by using Java with Spring Framework.
The project contain many package:
- config: contain the configuration file(security, url, ...)
- controller: contain controllers and rest controllers
- entity: contain model of each table from db
- repository: connection between web application and db
- service: contain logic code
- utils: contain utilities such as Config File, Enums, Datatable, ...
- viewmodel: custom model for passing data from controller to view.


### Part 2 - Database Desin
![alt DBDesign](https://i.imgur.com/of9bCGk.jpg)  
[x] Design database  
[x] Design entity base on DB  

### Part 3 - Security
This web page will have three roles, GUEST, USER(GAMER) and ADMIN.  
GUEST can only see generic information.  
USER can create their profile with playing games, playing times and get recommendation.  
ADMIN can fetch data from API and put into server database  
[x] Login  
[x] Register  
[x] Logout  

### Part 4 - Fetching data
Games and Genre data will be fetch from GiantBomb database by using their supported API (https://www.giantbomb.com/api/)  
ADMIN will login and choose Fetch DB to get data/put new data into database.  
[x] Fetch Genres data  
[x] Fetch Games data  
[x] Because of the limitation of free API, make the fetching process delay T time every N request
[x] Test the crawler

### Part 5 - User ability
[x] View account detail  
[x] Fix the account detail page to show more information.  
[x] Add game with time  
[x] Delete game time  
[x] View list of game and number of user  
[x] View gamer who play a specific game  
[x] Sort list of user by number of following  
[x] Make list of games searchable  
[x] Can redirect to Gamer detail page/Game detail page from list of users/games  

### Part 6 - Connecting people
Two USER(GAMER) can connect with each other after they login and go to the other profile.  
[x] View list of gamer  
[x] Make list of gamer searchable  
[x] Sort by number of gamer(Option 2)  
[x] Follow/Un-follow one gamer  
[x] View Friend/Following list

### Part 7 - Commenting/Chatting
Two USER(GAMER) can communicate with each other after they login and go to the other profile.  
[x] Add database to support comment function  
[x] Implement comment function  
[x] Calculate overall score of account after it has new comment.  
[x] Show a list of comment.  
[x] Sort list of comment by comment time.  