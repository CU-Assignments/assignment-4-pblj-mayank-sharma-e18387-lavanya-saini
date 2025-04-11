import java.util.*;

class Card {
    private String symbol;
    private String value;
    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }
    public String getSymbol() {
        return symbol;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return value + " of " + symbol;
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Collection<Card> deck = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cards: ");
        int numCards = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numCards; i++) {
            System.out.print("Enter card " + (i + 1) + " symbol (Hearts, Spades, Diamonds, Clubs): ");
            String symbol = scanner.nextLine();
            System.out.print("Enter card " + (i + 1) + " value: ");
            String value = scanner.nextLine();
            deck.add(new Card(symbol, value));
        }
        System.out.print("Enter the symbol to search for (Hearts, Spades, Diamonds, Clubs): ");
        String symbolToFind = scanner.nextLine();
        System.out.println("Cards with symbol " + symbolToFind + ":");
        for (Card card : deck) {
            if (card.getSymbol().equalsIgnoreCase(symbolToFind)) {
                System.out.println(card);
            }
        }
        scanner.close();
    }
}