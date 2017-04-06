
/**
 * This is where all the things you can interact with will be
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item {
    private String look;    //A string that holds a description of the object.
    private String name;    //The name of the object.
    
    /**
     * If for some reason you want to make a object with no name or description.
     */
    public Item() {
        look = "";
        name = "";
    }
    
    /**
     * This is the normal constructor. Why would you use the other one.
     */
    public Item(String look, String name) {
        this.look = look;
        this.name = name;
    }
    
    public Item(String name) {
        this("It's a " + name, name);
    }
    
    
    public void use(Player player, String action) {
        switch (action) {
            case "look": this.Look(player);
                break;
            case "eat": this.Eat(player);
                break;
            case "open": this.Open(player);
                break;
            case "close": this.Close(player);
                break;
            case "wear": this.Wear(player);
                break;
            case "use": this.Use(player);
                break;
            case "place": this.Place(player);
                break;
            case "go": this.Go(player);
                break;
            case "take": this.Take(player);
                break;
            default:
            System.out.println("Trying to " + action + " " + name + " doesn't do anything.");
        }
    }
    
    /**
     * These are the default interactions for all objects. If a new item doesn't have  it's own interactions, it'll use these by default.
     */
    public void Look(Player player) {
        System.out.println(this.getLook());
    }
    
    public void Eat(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("You shouldn't eat that!");
        } else if (rand < 50) {
            System.out.println("You'll spoil your dinner!");
        } else if (rand < 75) {
            System.out.println("You eat the " + name + ". You die.\n\nGame Over\n\njklol");
        } else {
            System.out.println("You don't really feel like eating the " + name + ".\nMaybe if you hadn't had that cake earlier you'd have enough room for some " + name + " now." + 
                               "\nI told you you'd ruin your appetite but you never listen do you. You used to be so charming. What happened to the dashing young man I married?" +
                               "\nHonestly. If you're just going to be like this all the time I may as well just move out.\nOh don't give me that look, we both know that this has"+
                               " been coming for a long time. Oh? Fine. Fine! I'm leaving right now. I already packed, anyways.\nGoodbye, George.");
        }
        
    }
    
    public void Open(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("That's either not something you can open, or I screwed up my code.");
        } else if (rand < 50) {
            System.out.println("You open the " + name + ". There's nothing. Happy? You ruined a perfectly good " + name + ", just because you THOUGHT there MIGHT be something in it.\n" +
                               "Do you try to open your cat? Is that why mommy won't let you have any pets? You disgust me. You disgust me so much, I'm just going to pretend youd didn't\n" +
                               "open the " + name + ", just so I can fool myself into thinking that there's some hope for humanity.");
        } else if (rand < 75) {
            System.out.println("You would if you could but you can't.");
        } else {
            System.out.println("Wait was this supposed to open? I didn't code this to open. It's probably not supposed to open. Send me a bug report or whatever if it is, though.");
        }
    }
    
    public void Close(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("You try to close it, but you can't. Because that's stupid. You're stupid.\nOr maybe I'm stupid and you should be able to close this.\n Whatever.");
        } else if (rand < 50) {
            System.out.println("You can't close it because it doesn't close. Or open. Why would you even want to close a " + name + "?");
        } else if (rand < 75) {
            System.out.println("Did your parents close a " + name + " on your head when you we're a kid? No they didn't. Because you can't close a " + name + ".");
        } else {
            System.out.println("No.");
        }
    }
    
    public void Wear(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("You can't find the holes, so you give up.\nWait frig that sounds wrong.");
        } else if (rand < 50) {
            System.out.println("You would, but it clashes with your purse.");
        } else if (rand < 75) {
            System.out.println("It's too tight, it won't fit.\n\n( ͡° ͜ʖ ͡°)");
        } else {
            System.out.println("It's high fashion!");
        }
    }
    
    public void Use(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("USE is too vague for this item. Try EATing or WEARing it.");
        } else if (rand < 50) {
            System.out.println("Are you just going to USE it and throw it away like you USEd me?");
        } else if (rand < 75) {
            System.out.println("LucasArts would insult you right about now for trying to USE something you can't USE, but I understand. Often times a developer will miss\n" +
                               "an obvious interaction, so when the player tries to perform that interaction, they're surprised when the game calls them stupid. I'm not\n" +
                               "going to insult you for doing something that is, in all likelyhood, something I should have coded into the game. No, I'm going to insult\n" +
                               "you because I feel like it, and it's fun. I saw your mother on the corner last night, it's amazing she gets work with a face like that.\n" +
                               "I suppose someone must hire her, or else how were you born? Well going by your looks, your father, whoever he is, wasn't much of a looker\n" +
                               "either, so maybe he was just desperate, and couldn't afford anyone better. I like your shoes by the way, which dumpster did you get them from?\n" +
                               "Alright I'm done.");
        } else {
            System.out.println("You can't.");
        }
    }
    
    public void Place(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("You can't remove quest items from your inventory.\nEspecially if they're not in your inventory.");
        } else if (rand < 50) {
            System.out.println("Why are you trying to put it down? What did it do to you? It's okay, " + name + ", I think you're special.");
        } else if (rand < 75) {
            System.out.println("You can't. You're not holding it.");
        } else {
            System.out.println("You place it right next to itself. Causality collapses. The universe folds in on itself. Somewhere, a dog meows. Actually you don't, but would't it be cool if you did?");
        }
    }
    
    public void Go(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("You enter the " + name + ". To your surprise, you are now in a forest! Following a path takes you to a castle, where you embark on a magnificent journey\n" +
                               "throughout the kingdom, exterminating dragons, defeating evil sorcerers, and rescuing fair damsels. While the odds are against you, you conquer each challenge\n" +
                               "in your path with the help of your sacred sword and shield. Eventually, you retire, using the fortunes aquired over your adventures to build a small cabin by a\n" +
                               "waterfall to live out the rest of your days in peace in. Except none of that happens actually because that's stupid.");
        } else if (rand < 50) {
            System.out.println("Don't go, it's suicide!");
        } else if (rand < 75) {
            System.out.println("Poekman go to the polls");
        } else {
            System.out.println("Go to hell.");
        }
    }
    
    public void Take(Player player) {
        int rand = MainThing.RandomNum(0, 100);
        
        if (rand < 25) {
            System.out.println("You throw your back out trying to pick up the " + name + ".");
        } else if (rand < 50) {
            System.out.println("You can't fit it in your infinitely large pockets.");
        } else if (rand < 75) {
            System.out.println("*quack*");
        } else {
            System.out.println("Why?");
        }
    }
    
    /**
     * Methods for changing the name and description of the item.
     */
    public void setLook(String newLook) {
        look = newLook;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    /**
     * Use this to get the name and description of the item.
     */
    public String getLook() {
        return look;
    }
    
    public String getName() {
        return name;
    }
    
    public String toString() {
        return name;
    }
}
