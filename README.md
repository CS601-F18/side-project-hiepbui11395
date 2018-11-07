### Gamer Portal
Gamer portal is a page for gamer to find and connect with others who have the same favorite and time.

### Part 1 - System Design
The web application will be implemented by using Java with Spring Framework.

### Part 2 - Database Desin
![alt DBDesign](https://i.imgur.com/of9bCGk.jpg)

### Part 3 - Security
This web page will have three roles, GUEST, USER(GAMER) and ADMIN.
GUEST can only see generic information.
USER can create their profile with playing games, playing times and get recommendation.
ADMIN can fetch data from API and put into server database

### Part 4 - Fetching data
Games and Genre data will be fetch from GiantBomb database by using their supported API (https://www.giantbomb.com/api/)
ADMIN will login and choose Fetch DB to get data/put new data into database.

### Part 5 - Recommend USER to each other
Base on their input game -> playing time, system will suggest people who have the same interesting, then the same playing time


### Part 6 - Connecting people
Two USER(GAMER) can connect with each other after they login and go to the other profile.

### Part 7 - Commenting/Chatting
Two USER(GAMER) can communicate with each other after they login and go to the other profile.

### Part 8 - Donating(Considering)
One user can donate to the other (Mock only)