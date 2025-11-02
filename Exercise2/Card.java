package Exercise2;

public class Card {
    private String name;
    private String attributes;
    private int amount;

    Card(String name, String attributes, int amount) {
        this.setName(name);
        this.setAttributes(attributes);
        this.setAmount(amount);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public String getAttributes() {
        return this.attributes;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getDetailsR1() {
        String res = String.format("%s\n %s\n %s\n %s\n", " ", this.getName(), this.getAttributes(),
                this.getAmount());
        return res;
    }

    public String getDetailsR2() {
        String res = String.format("%30s\n %30s\n %30s\n %30s\n", " ", this.getName(), this.getAttributes(),
                this.getAmount());
        return res;
    }

    public String getDetailsR3() {
        String res = String.format("%60s\n %60s\n %60s\n %60s\n", " ", this.getName(), this.getAttributes(),
                this.getAmount());
        return res;
    }

    public void executeCard(Card card, boolean isPlayer) {
        if (isPlayer) {
            System.out.println("\nYou played: " + this.getName());

            if (card.getAttributes().equals("Burst")) {
                Present.hpBot -= card.getAmount();
                System.out.println("Dealt " + card.getAmount() + " damage to the Bot!");
                System.out.println("Bot Current HP: " + Present.hpBot);

            } else if (card.getAttributes().equals("Poison")) {
                Present.poisonBot += card.getAmount();
                Present.hpBot -= card.getAmount();
                System.out.println("Added " + card.getAmount() + " poison damage to the Bot!");
                System.out.println("Bot Current HP: " + Present.hpBot);

            } else if (card.getAttributes().equals("Heal")) {
                Present.hpPlayer += card.getAmount();
                System.out.println("Healed " + card.getAmount() + " HP!");
                System.out.println("Your Current HP: " + Present.hpPlayer);
            }

        } else {
            System.out.println("\nBot played: " + this.getName());

            if (card.getAttributes().equals("Burst")) {
                Present.hpPlayer -= card.getAmount();
                System.out.println("Dealt " + card.getAmount() + " damage to the Player!");
                System.out.println("Player Current HP: " + Present.hpPlayer);

            } else if (card.getAttributes().equals("Poison")) {
                Present.poisonPlayer += card.getAmount();
                Present.hpPlayer -= card.getAmount();
                System.out.println("Added " + card.getAmount() + " poison damage to the Player!");
                System.out.println("Player Current HP: " + Present.hpPlayer);

            } else if (card.getAttributes().equals("Heal")) {
                Present.hpBot += card.getAmount();
                System.out.println("Healed " + card.getAmount() + " HP!");
                System.out.println("Your Current HP: " + Present.hpBot);
            }

        }
    }
}
