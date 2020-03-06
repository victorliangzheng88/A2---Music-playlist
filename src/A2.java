/* Class: CISC 3130
 * Section: TY9
 * EmplId: 23731694
 * Name: Victor Liang Zheng
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class A2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Read in all the files needed
        List<Data> datas1 = readDatasFromCSV("regional-global-weekly-latest.csv");
        List<Data> datas2 = readDatasFromCSV("regional-global-weekly-2020-02-14--2020-02-21.csv");

        //Merge the files together without duplicates element using mergeData()
        List<Data> datasMerged = mergeAndSort(datas1, datas2);
        
        //Making a copy of the merged data and sort it
        List<Data> datasMergedCopy = datasMerged;
        Collections.sort(datasMergedCopy);
        
        //Create a new stack to hold the song history list
        Stack<Data> st = new Stack<Data>();
        
        //Integer to hold the location of songs
    	int songPlace = 0;
    	
    	//a while loop that kept asking the user for the input to run the play list
    	while(true){
        System.out.println("Please choose one from the following option:"
    			+ "\n1- View Playlist"
    			+ "\n2- Play Song/Play Next Song"
    			+ "\n3- Show Song History");
    	
    	Scanner sc = new Scanner(System.in);
    	int option = sc.nextInt();

        //switch that act according to the input of the user
    	switch(option){
    	case 1: //"View Playlist"
    		System.out.println(datasMergedCopy);
    		System.out.println("");
    		break;
    	case 2: //"Play Song/Play Next Song"
    		System.out.println("\nCurrent Song Playing: " + datasMergedCopy.get(songPlace));
    		System.out.println("");
    		st.push(datasMergedCopy.get(songPlace));
    		songPlace++;
    		break;
    	case 3: //"Show Song History"
    		printStack(st);
    		System.out.println("\n");
    		break;
		default:
			System.out.println("\nThat is not a valid option!\n");
		}
    	}
    }

	//A method that read data from csv files
    public static List<Data> readDatasFromCSV(String fileName) throws FileNotFoundException {
        
    	List<Data> datas = new ArrayList<>();  
        FileReader fr = new FileReader(fileName);
        
        // create an instance of BufferedReader
        try (BufferedReader br = new BufferedReader(fr)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                Data Data = createData(attributes);

                // adding Data into ArrayList
                datas.add(Data);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return datas;
    }

    //A method to return a data class after it was passed 
    //a string array for argument
    public static Data createData(String[] metadata) {
        String position = metadata[0];
        String trackName = metadata[1];
        String artist = metadata[2];
        String streams = metadata[3];
        String url = metadata[4];

        // create and return Data of this metadata
        return new Data(position, trackName, artist, streams, url);
    }

    //A method that merge two list of data object into one list
    public static List<Data> mergeAndSort (List<Data> datasOne, List<Data> datasTwo){
    	List<Data> datas2Copy = new ArrayList<>(datasTwo);
    	datasOne.removeAll(datas2Copy);
    	datasOne.addAll(datas2Copy);
        //Collections.sort(datas2Copy);
    	return datas2Copy;
    }
    
    //A method that prints the stack without removing the elements 
    //from the stack
    public static <T> void printStack(Stack<T> stack){
    	Stack<T> temp = new Stack<>();
    	while (!stack.isEmpty()){
    		System.out.print(stack.peek());
    		temp.push(stack.pop());
    	}
    	while(!temp.isEmpty()){
    		stack.push(temp.pop());
    	}
    }
    
}

class Data implements Comparable{
	private String position;
	private String trackName;
	private String artist;
    private String streams;
    private String url;

    //Constructor of the class
    public Data (String position, String trackName, String artist, String streams, String url) {
        this.position = position;
        this.trackName = trackName;
        this.artist = artist;
        this.streams = streams;
        this.url = url;
    }

    //returns the position of the song
    public String getPosition() {
        return position;
    }

    //sets the position of the song
    public void setPosition(String position) {
        this.position = position;
    }

    //returns the name of the song
    public String getTrackName() {
        return trackName;
    }

    //sets the name of the song
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    //returns the artist name
    public String getArtist() {
        return artist;
    }

    //sets the artist name
    public void setArtist(String artist) {
        this.artist = artist;
    }
    
    //returns the number of streams
    public String getStreams() {
        return streams;
    }

    //sets the number of streams
    public void setStreams(String streams) {
        this.streams = streams;
    }
    
    //returns the url of the song
    public String getUrl() {
        return url;
    }

    //sets the url for the song
    public void setUrl(String url) {
        this.url = url;
    }

    //Override the toString method for the needs of the program
    @Override
    public String toString() {
        return  "\n" + "[Track Name= " + trackName + " Artist= " + artist + "]" ;
    }
    
    //Override the compareTo method to compare only the trackNames
    @Override
    public int compareTo(Object o) {
        return this.getTrackName().compareTo(((Data) o).getTrackName());
    }
    
}