public class Game {
    public static void main(String[] args) {
        //GAME Beginning
        Cards card = new Cards();
       int cardName = card.getCard();
       // FIRST CARD
        System.out.printf("Your first card is "+cardName+". ");
       // SECOND CARD
        int cardName2 = card.getCard();
        System.out.println("Your second card is "+cardName2);
        System.out.println("TOTAL SCORE IS "+(cardName2+cardName));
        int firstTotal = (cardName2+cardName);
        if (firstTotal==21){
            System.out.println("BLACK JACK !!! YOU WIN!");
            return;
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to 1.HIT or 2.STAND");
        int player = scan.nextInt();
        switch (player){
            //HIT 3 card
            case 1:
            int cardName3=card.getCard();
            System.out.println("Your third card is "+cardName3);
            System.out.println("TOTAL SCORE IS "+(cardName3+cardName2+cardName));
            int totalPlayer = (cardName3+cardName2+cardName);
            if (totalPlayer>21){
                System.out.println("Sorry, Dealer Wins");
                break;
            } else if (totalPlayer==21){
                System.out.println("BLACK JACK You win!!");
                return;
            }
            // HIT AFTER 3 CARD
            System.out.println("Do you want to 1.HIT or 2.STAND");
            int player2 = scan.nextInt();
            switch (player2){
                case 1:
                    int cardName4=card.getCard();
                    System.out.println("Your four card is "+cardName4);
                    int totalPLayer1= totalPlayer+cardName4;
                    System.out.println("TOTAL SCORE IS "+(totalPLayer1));
                    if (totalPLayer1>21){
                        System.out.println("Sorry, Dealer wins");
                        break;}
                   //STAND AFTER 3 CARD DEALER IN GAME!
                case 2:
                    System.out.println("Now Dealer in game");
                    Dealer dealer4 = new Dealer();
                    int dealerCard1=dealer4.dealerGetCard();
                    System.out.printf("Dealer first card is "+dealerCard1+".");
                    Dealer dealer5 = new Dealer();
                    int dealerCard2=dealer5.dealerGetCard();
                    System.out.println("Dealer second card is "+dealerCard2);
                    System.out.println("TOTAL SCORE is "+(dealerCard2+dealerCard1));
                    // DEALER LOGIC
                    int dealerTotal = dealerCard2+dealerCard1;
                    if ((dealerTotal)==21){
                        System.out.println("Black Jack Dealer win!");
                    }
                    else if ((dealerTotal)<=18) {
                        int dealerCard3 = dealer5.dealerHit();
                        System.out.println("Dealer third card is " + dealerCard3);
                        int dealerTotal2 = dealerTotal + dealerCard3;
                        System.out.println("DEALER TOTAL SCORE IS " + (dealerTotal2));
                        if (dealerTotal2 > 21) {
                            System.out.println("Congratulation you Win!");
                        } else if (dealerTotal2 >= totalPlayer) {
                            System.out.println("Sorry Dealer win. Your score is " + totalPlayer + " and dealer score is " + dealerTotal2);
                        } else if (dealerTotal2 < totalPlayer) {
                            System.out.println("Congratulations , you won. Your score is " + totalPlayer + " and dealer score is " + dealerTotal2);
                        }
                    } else if ((dealerTotal)>21) {
                        System.out.println("Congratulations , you won");
                        return;

                }
            }
             // DEALER in GAME after second card and 1 STAND
            break;
            case 2:
                // Dealer get 1 card
                System.out.println("Now Dealer in game");
                Dealer dealer = new Dealer();
                int dealerCard1=dealer.dealerGetCard();
                System.out.printf("Dealer first card is "+dealerCard1+".");
                Dealer dealer2 = new Dealer();
                // Dealer get 2 card
                int dealerCard2=dealer.dealerGetCard();
                System.out.println("Dealer second card is "+dealerCard2);
                int dealerTotal = (dealerCard1+dealerCard2);
                System.out.println("TOTAL SCORE is "+(dealerTotal));
                //if BLack Jack dealer win
                if ((dealerTotal)==21){
                    System.out.println("Black Jack Dealer win!");
                }
                //IF dealer is score is less than 18
                else if((dealerTotal<=18)){
                    int dealerCard3 = dealer.dealerHit();
                    System.out.println("Dealer third card is "+dealerCard3);
                    int dealerTotal2=dealerTotal+dealerCard3;
                    System.out.println("DEALER TOTAL SCORE IS "+(dealerTotal2));
                    if (dealerTotal2>21){
                        System.out.println("Congratulation you Win!");
                    } else if (dealerTotal2>=firstTotal) {
                        System.out.println("Sorry Dealer win. Your score is "+firstTotal+ " and dealer score is "+dealerTotal2);
                    } else if (dealerTotal2<firstTotal){
                        System.out.println("Congratulations , you won. Your score is "+firstTotal+ " and dealer score is "+dealerTotal2);
                    }
                    //IF dealer score is 19!
                } else if ((dealerTotal==19)){
                    if (dealerTotal>=firstTotal){
                        System.out.println("Sorry Dealer win. Your score is "+firstTotal+ " and dealer score is "+dealerTotal);
                    } else if (dealerTotal<firstTotal){
                        System.out.println("Congratulations , you won. Your score is "+firstTotal+ " and dealer score is "+dealerTotal);
                    }
                    //If dealer score is 20!
                 }  else if ((dealerTotal==20)){
                    if (dealerTotal>=firstTotal){
                        System.out.println("Sorry Dealer win. Your score is "+firstTotal+ " and dealer score is "+dealerTotal);
                    } else if (dealerTotal<firstTotal){
                        System.out.println("Congratulations , you won. Your score is "+firstTotal+ " and dealer score is "+dealerTotal);
                    }
                }
            }
        }
    }

    class Cards {
        public int getCard() {
            int value = (int) (Math.random() *8);

        return value+2;
    }
    }

    //CLASS DEALER
    class Dealer{
    public int dealerGetCard(){
        int value2 = (int) (Math.random() *11);
        return value2+2;
    }


    public int dealerHit(){
        int value2 = (int) (Math.random() *11);
        return value2+2;
    }

    }
