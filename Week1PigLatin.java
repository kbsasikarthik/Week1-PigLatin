package week1capstone;

import java.util.Scanner;

public class Week1PigLatin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println("~~~~~~~ ~~ ~~~ ~~~ ~~~~~ ~~~~~~~~~~~\n\n");
		do {
			System.out.print("Enter a line to be translated: ");
			String inputString =sc.nextLine();
			
			String[] wordArray = inputString.trim().split(" ");
			
			for (String partOfString: wordArray) {
				if(charCheck(partOfString)) {
					System.out.print(partOfString+" ");
				}
				else {
					if(partOfString.toLowerCase().startsWith("a") ||partOfString.toLowerCase().startsWith("e")|| partOfString.toLowerCase().startsWith("i") ||partOfString.toLowerCase().startsWith("o") || partOfString.toLowerCase().startsWith("u")){
						//if(partOfString.startsWith("a") ||partOfString.startsWith("e")|| partOfString.startsWith("i") ||partOfString.startsWith("o") || partOfString.startsWith("u")){
							partOfString =partOfString.concat("way");
							System.out.print(" "+partOfString+" ");
						}
							
					else {
						// if the word starts with a consonant, call the method to 
						// convert it to PigLatin and print it
					    String latin = toPigLatin(partOfString);
					    System.out.print(latin+" ");
					}
				}
			}
			  
			// check if the user wants to continue
			System.out.print("\n\nTranslate another line? (y/n) : ");
			choice = sc.next();
			sc.nextLine();
			}while(choice.toLowerCase().startsWith("y")); // continue the loop only if the user agrees
		    
		    // display concluding message
			System.out.println("\nThanks for trying the translator. Bye");
			sc.close();
	}



// translates the string passed in to PigLatin and returns it.
// Split the word at first occurrence of a vowel,
// move that substring to the beginning of the word and add "ay" to the end
  
  private static String toPigLatin(String word) {
    int splitPosition = firstVowel(word);
    return word.substring(splitPosition)+word.substring(0, splitPosition)+"ay";
  }

// finds the first occurrence of a vowel in a word
// it loops through each letter of the word and finds the 
// occurrence of the vowels. If there are no vowels found, it returns 0   

  private static int firstVowel(String word) {
    word = word.toLowerCase();
    for (int i=0; i<word.length(); i++)
      if (word.charAt(i)=='a' || word.charAt(i)=='e' ||
          word.charAt(i)=='i' || word.charAt(i)=='o' ||
          word.charAt(i)=='u')
        return i;
    return 0;
  }

// method that checks for the occurrence of numbers and special characters and numbers in a given word
// returns true if there are onyl alphabets in the given word; else it returns false
private static boolean charCheck(String words) {

	for (int i=0; i<words.length();i++) {
		char charAtI = words.charAt(i);
		if(!((charAtI>='a' && charAtI <='z') || (charAtI==' ')||(charAtI>='A' && charAtI <='Z')))
	 
			return true;
		
	}
	return false;

}
}
