package 作業2;


		// TODO Auto-generated method stub
		 import java.util.ArrayList; 
		 import java.util.HashMap; 
		 import java.util.Scanner; 
		 /* 
		  * ID: B0444230: please add student ID here 
		  * Name: 曾立崴: please add student name here 
		  */ 
		 public class 作業2 { 
		 
		 
		 	public static void main(String[] args) { 
		 		Scanner sc = new Scanner(System.in); 
		 		System.out.println("input N(deck of cards):"); 
		 		String testn= sc.nextLine();  
		          
		 		int nDeck=Integer.parseInt(testn); 
		 		Deck deck=new Deck(nDeck); 
		 		//TODO: please check your output, make sure that you print all cards on your screen 
		 		deck.printDeck(); 
		 		 
		 		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){ 
		 			System.out.println("Well done!"); 
		 		}else{ 
		 			System.out.println("Error, please check your sourse code"); 
		 		} 
		 	} 
		 	/* 
		 	 * This method is used for checking your result, not a part of your HW2 
		 	 */ 
		 	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){ 
		 		//check the output  
		 		boolean isCorrect=true;; 
		 		HashMap <String,Integer> checkHash=new HashMap<String,Integer>(); 
		 		for(Card card:allCards){ 
		 			int suit= card.getSuit(); 
		 			int rank = card.getRank(); 
		 			if(suit>4||suit<1||rank>13||rank<1){ 
		 				isCorrect=false; 
		 				break; 
		 			} 
		 			if(checkHash.containsKey(suit+","+rank)){ 
		 				checkHash.put(suit+","+rank,  
		 						checkHash.get(suit+","+rank)+1); 
		 			}else{ 
		 				checkHash.put(suit+","+rank, 1); 
		 			} 
		 		} 
		 		if(checkHash.keySet().size()==52){ 
		 			for(int value:checkHash.values()){ 
		 				if(value!=nDeck){ 
		 					isCorrect=false; 
		 					break; 
		 				} 
		 			} 
		 		}else{ 
					isCorrect=false; 
		 		} 
		 		return isCorrect; 
		 	} 
		 } 
		 /* 
		  * Description: TODO:設立3個迴圈分別負責牌有幾副、花色，還有數字， 然後最後兩句是把cards.add(card);裡面card的method整個放到cards這個ArrayList裡面
		  */ 
		 class Deck{ 
			private ArrayList<Card> cards; 
		 	//TODO: Please implement the constructor 
		 	public Deck(int nDeck){ 
		 		cards=new ArrayList<Card>();
		 		for (int a=1;a<=nDeck;a++){
		 		for (int x=1;x<=4;x++){	
		 		for (int y=1;y<=13;y++){
		 		Card card=new Card(x,y);
		 		cards.add(card);
		 		}
		 		}
		 		}
		 		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker 
		 		//Hint: Use new Card(x,y) and 3 for loops to add card into deck 
		 		//Sample code start 
		 		//Card card=new Card(1,1); ->means new card as clubs ace 
		 		//cards.add(card); 
		 		//Sample code end 
		 
		 
		 	}	 
		 	//TODO: Please implement the method to print all cards on screen 
		 	public void printDeck(){
		 		for(Card z: cards)
		 		{
		 			z.printCard();
		 		}
		 		//Hint: print all items in ArrayList<Card> cards,  
		 		//please implement and reuse printCard method in Card class 
		 	} 
		 	public ArrayList<Card> getAllCards(){ 
		 		return cards; 
		 	} 
		 } 
		 /* 
		  * Description: TODO:設S,R是為了給前面的程式用，printCard是為了印出每張牌的花色跟數字，return是回傳花色跟數字
		  */ 
		 class Card{ 
		 	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4 
		 	private int rank; //1~13 
		 	public Card(int s,int r){ 
		 		suit=s; 
		 		rank=r; 
		 	}	 
		 	//TODO: 1. Please implement the printCard method 
		 	public void printCard(){ 
				//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace 
		     System.out.println(suit+","+rank);
		 	} 
		 	public int getSuit(){ 
		 		return suit; 
		 	} 
			public int getRank(){ 
		 		return rank; 
		 	} 
	}