# Simon Game for Finch Robot 1.0
The preliminary group assignment based on creating a Simon game with BirdBrain Technologies Finch 1.0 - this was developed as part of our formative assignment with my tutorial group for my first year study.

### Requirements Specification 📃

#### System Scope 🔍

The scope of the system is to design and implement a computer program that will work with our finch and robots. The purpose of designing and implementing a computer program is to help build the skills and knowledge that we will need to undertake future assignments. The purpose of this assignment is to receive feedback as well as support from our tutors. Furthermore, working alongside our teams will also give us the opportunity to enhance our team management and learn from each other.

#### Objective 🎯

The program that will be implemented and designed is a Simon says program. Simon is an electronic memory game from the early 80s which includes a device that has four different colours on it that will light up random buttons in a random order which the player must then repeat the order by pressing on the correct button.

### Extra Features ➕

- Graphical User Interface was designed to help with ease for accessibility.
- The finch colour chooser allows the user to personalise the finch colours, this also helps to change the finch colours for colour-blind people.
- Virtual finches have been implemented to allow for people to play the game based on the number of finches they have connected (e.g. if they have two finches connected, then they are able to use the other three finches as virtual buttons).
- The lives/points system allows for a competitive element between users.
- There were issues with the SQL database (due to the nature of University security denying access to the server), so the statistics menu was partially implemented, we store the user’s statistics in a flat-file stored in their home folder. This is persistently stored so we can retrieve statistics whenever the game is launched without loosing it. When the game is lost, you will be able to see your previous high score (the GUI menu was not 100% implemented).
- If we could implement the statistics feature fully, this would be helpful for medical use where users with dementia can see if their memory improves whilst playing the game.
- There is a small little sound when you play the game and exit the game.

### Screenshots 📸

##### Main Menu 

JavaFX was used to create the main menu of the game

![MainMenu](/docs/assets/MainMenu.png)

##### Settings

###### Colour Picker

Ability to choose Finch beak colours which flash on the individual finch (including the virtual finch if not enough finches are connected)

![SettingsColourPicker](/docs/assets/SettingsColourPicker.png)

###### Colour Picker Preview (virtual)

![SettingsPreview](/docs/assets/SettingsPreview.png)

##### Single Player

The user picks how many Finch robots are connected - the number of non-present Finch robots (the game requires 5), these would be virtual (on-screen clickable).

![SinglePlayerDeviceCount](/docs/assets/SinglePlayerDeviceCount.png)

The game would then display virtual Finches within the game, a lives and score counter is present to help motivate the user. The scores will be stored, where the user can view their previous high score.

![VirtualFinch](/docs/assets/VirtualFinch.png)

In the event the user runs out of lives, the game will end.

![GameOver](/docs/assets/GameOver.png)

##### Proof of Concept

These feature interfaces was developed but not implemented successfully due to network and time constraints.

###### Multiplayer

![MultiplayerPOC](/docs/assets/MultiplayerPOC.png)

###### Statistics

![StatisticsPOC](/docs/assets/StatisticsPOC.png)

### Team 🧑🏻‍🤝‍🧑🏻

#### Tutor Group

Green 46

Professor. David Gilbert

#### Team Members

| Henri Koci 1808346 | Mohammed Yousaf Kouhdamani 1919170 | Khalil Magbok 1921932 | Arjon Kucaj 190621 | Ethan Samuel Ludlam 1915222 | Usama Akbar 1918711 | Terence Kwun Hoo Liu 1908563 |
| ------------------ | ---------------------------------- | --------------------- | ------------------ | --------------------------- | ------------------- | ---------------------------- |
