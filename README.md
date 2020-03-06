# A2---Music-playlist

This projects demonstrates how to read in multiples files of the top streaming music with the artist in spotify and convert those datas into a playlist with the possibility of manipulating those datas with a song history list.

In this project I've used Linked List and Stack

I use linkedlist to read in the data in the file. The reason that I use linked list is that the operation 
with linked list is much easier and furthermore, it can grow and shrink during run time,
which makes insertion and deletion much easier.

I also use Stack to create a song history list because stack is LIFO (Last in First Out) and that is exactly how I wanted my song history list to look like as it was print out in the console.

The datas were merged together into one list and they are all sorted based on the track names alphabetically in ascending orderas the VIP client asked. The program were able to manage multiple files by creating multiple list of data in the main method and merge them into one list. The data were merged and sorted without duplicates elements because I believe duplicates songs are unneccesarry in a playlist as the VIP client might not want to listen to the same song over and over.

I've decided to have a interaction with the user by asking the user for input because I believe that is the purpose of the playlist, so that the user can manipulate over the playlist by either viewing the list or playing next song or viewing the song history list.

## Setup

These are the steps to compile `A2.java` and run the program `A2`. Source code is found in the src folder. These steps are for use with command line workflow such as with a terminal.

1. Sign up for a GitHub account if you don't have one. Set up your SSH keys with github.
2. Clone this repository `git clone git@github.com:victorliangzheng88/A2---Music-playlist.git` to your machine to get a copy.
3. Move into the project's root directory with `cd A2---Music-playlist` [^1]
4. Move again into the subdirectory `src` using the command `cd src`
5. Compile the java file using the java compiler command `javac A2.java`
6. Run the compiled java program with the java command `java A2`

Another way to run the program is to use the integrated development environment (IDE), eclipse.

1. Download and Install Java, and Eclipse if the programs are not yet installed.
2. Go to https://github.com/victorliangzheng88/A2---Music-playlist.git using web browser.
3. Download the files in the folder called `data` and `src` and save them into the same folder in your computer.
4. Open eclipse after installed and click File on the left top corner and click Open File.
5. Choose the file name of `A2.java` and click Open.
6. Click Run.

You should see an output similar to the following with similar input:

```sh
Please choose one from the following option:
1- View Playlist
2- Play Song/Play Next Song
3- Show Song History
1
[
[Track Name= "10 Artist= 000 Hours (with Justin Bieber)"], 
[Track Name= "All I Want - From ""High School Musical: The Musical: The Series""" Artist= Olivia Rodrigo], 
[Track Name= "Alone Artist=  Pt. II"], 
[Track Name= "Lose Yourself - From ""8 Mile"" Soundtrack" Artist= Eminem], 
[Track Name= "Numbers (feat. Roddy Ricch Artist=  Gunna and London On Da Track)"], 
[Track Name= "thank u Artist=  next"], 
[Track Name= 3 Nights Artist= Dominic Fike], 
.......

Please choose one from the following option:
1- View Playlist
2- Play Song/Play Next Song
3- Show Song History
2

Current Song Playing: 
[Track Name= "10 Artist= 000 Hours (with Justin Bieber)"]

Please choose one from the following option:
1- View Playlist
2- Play Song/Play Next Song
3- Show Song History
2

Current Song Playing: 
[Track Name= "All I Want - From ""High School Musical: The Musical: The Series""" Artist= Olivia Rodrigo]

Please choose one from the following option:
1- View Playlist
2- Play Song/Play Next Song
3- Show Song History
3

[Track Name= "All I Want - From ""High School Musical: The Musical: The Series""" Artist= Olivia Rodrigo]
[Track Name= "10 Artist= 000 Hours (with Justin Bieber)"]

Please choose one from the following option:
1- View Playlist
2- Play Song/Play Next Song
3- Show Song History
```
