import java.io.*;
public class Twitter {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
/**
* 
* @author Juan Camilo Pabon Pardo
* 
*/
    public static void top (String [] array_Tweet) throws IOException{//Hashtag and tags
    	
     	String [] words = new String [5];
    	int [] repetitions = new int [5];

		for (int i = 0; i < array_Tweet.length; i ++){//This loop go trhough the length of the array_Tweet
			
			int counter = 0;//The counter has been resarted in each iteration
			String keyWord = "";//The keyWord has been resarted in each iteration
	    	int index = -1;//The index has been resarted in each iteration
	    	
			if(array_Tweet [i].equals(words [0])||array_Tweet [i].equals(words [1])||array_Tweet [i].equals(words [2])||array_Tweet [i].equals(words [3])||array_Tweet [i].equals(words [4]) && words [i].charAt(0) != '°') {
				
			}else {
				keyWord = array_Tweet [i];
				for (int j  = 0; j  < array_Tweet.length; j ++) {
					if(array_Tweet [i].equals(array_Tweet [j])) {
						counter += 1;//If the nickname coincide with another nickname the counter increase in one
					}
				}
				
				for (int k = repetitions.length - 2; k >= 0 ; k --) {//Search index 
					if(counter > repetitions [k]) {	
						
					}else {
						index = k;//Find the index to replace
						break;
					}
				}

				if(index ==-1) {
					index += 1;
					for (int l = 1; l < repetitions.length - index; l++) {
						repetitions [repetitions.length - l] = repetitions [(repetitions.length - l) -1];
						words [repetitions.length - l] = words [(repetitions.length - l) - 1];
					}
				}else {
					index += 1;
					for (int l = 1; l < repetitions.length - index; l++) {
						repetitions [repetitions.length - l] = repetitions [(repetitions.length - l) -1];
						words [repetitions.length - l] = words [(repetitions.length - l) - 1];
					}
				}
			
				repetitions [index] = counter;//Asing the repetitions in the index position of the top
				words [index] = keyWord;//Asing the nickname in the index position of the top

			}
		}
		for (int j = 0; j < repetitions.length; j++) {
			bw.write(words [j] + ": " + repetitions [j] + "\n");
			bw.flush();
		}
		bw.newLine();
    }
    public static void topWords (String [] array_Tweet) throws IOException{
    	
     	String [] words = new String [5];
    	int [] repetitions = new int [5];

		for (int i = 0; i < array_Tweet.length; i ++){//This loop go trhough the length of the array_Tweet
			
			int counter = 0;//The counter has been resarted in each iteration
			String keyWord = "";//The keyWord has been resarted in each iteration
	    	int index = -1;//The index has been resarted in each iteration
	    	
	    	if(array_Tweet.length > 3) {
	    		if(array_Tweet [i].equals(words [0])||array_Tweet [i].equals(words [1])||array_Tweet [i].equals(words [2])||
	    				array_Tweet [i].equals(words [3])||array_Tweet [i].equals(words [4])||
	    				array_Tweet [i].charAt(0) == '@' || array_Tweet [i].charAt(0) == '°' || array_Tweet [i].charAt(0) == '#') {
					
				}else {
					
					keyWord = array_Tweet [i];
					if(array_Tweet [i].length() > 3) {
						for (int j  = 0; j  < array_Tweet.length; j ++) {
							if(array_Tweet[i].equals(array_Tweet[j])) {
								counter += 1;//If the nickname coincide with another nickname the counter increase in one
							}
						}
						
						for (int k = repetitions.length - 2; k >= 0 ; k --) {//Search index 
							if(counter > repetitions [k]) {	
								
							}else {
								index = k;//Find the index to replace
								break;
							}
						}
	
						if(index ==-1) {
							index += 1;
							for (int l = 1; l < repetitions.length - index; l++) {
								repetitions [repetitions.length - l] = repetitions [(repetitions.length - l) -1];
								words [repetitions.length - l] = words [(repetitions.length - l) - 1];
							}
						}else {
							index += 1;
							for (int l = 1; l < repetitions.length - index; l++) {
								repetitions [repetitions.length - l] = repetitions [(repetitions.length - l) -1];
								words [repetitions.length - l] = words [(repetitions.length - l) - 1];
							}
						}
					
						repetitions [index] = counter;//Asing the repetitions in the index position of the top
						words [index] = keyWord;//Asing the nickname in the index position of the top
					}
				}
				
	    	}
			
		}
		for (int j = 0; j < repetitions.length; j++) {
			bw.write(words [j] + ": " + repetitions [j] + "\n");
			bw.flush();
		}
		bw.newLine();
    }
    public static String findNicks (String [] text, char Key) {
    	String nicks = "";
    	
    	for (int i = 0; i < text.length; i++) {
			if(text[i].charAt(0) == Key) {
				nicks += text [i] + " ";
			}
		}
    	
    	return nicks;
    }

    public static String findWords (String [] text, char Key) {
    	String words = "";
    	
    	for (int i = 0; i < text.length; i++) {
			if(text [i].charAt(0) == Key) {
				words += text [i] + " ";
			}
		}
    	
    	return words;
    }
    public static void main (String [] args) {
    
    	try{
    		 
		bw.write("Enter the text: \n");
		bw.flush();
		String text = br.readLine();
		
		String [] array_Tweets = text.split(" "); //Alt + 167 //Split the text by the rare character 
		
		System.out.println(array_Tweets.length);
		
		String nicks = findWords(array_Tweets, '°');
		String [] Nicks = nicks.split(" ");
	
		String trends = findWords(array_Tweets, '#');
		String [] Trends = trends.split(" ");
		
		String tags = findWords(array_Tweets, '@');
		String [] Tags = tags.split(" ");
		
		bw.write("\nTop of nicknames\n");
		bw.flush();
		top(Nicks);//Calls the top function		
		
		bw.write("\nTop of trends\n");
		bw.flush();
		top(Trends);//Calls the top function
		
		bw.write("\nTop of tags\n");
		bw.flush();
		top(Tags);//Calls the top function
		
		bw.write("\nTop of words\n");
		bw.flush();
		topWords(array_Tweets);
		
        }catch(Exception ex){
        	 ex.printStackTrace();
        }
    }
}
