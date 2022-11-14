public class Player {
    private String userName;
    private String passWord;
    private int chips;
    private int money;
    private int totalBet;
    private int wins;
    private int losses;
    private int gamesBlackJack;
    private int gamesRoulette;
    private int gamesUnknown;

    //Default constructor for Player
    public Player(){

    }
    //Constructor for Player
    public Player(String userName, String passWord, int chips, int money, int totalBet, int wins, int losses, int gamesBlackJack,
    int gamesRoulette, int gamesUnknown){
        this.userName = userName;
        this.passWord = passWord;
        this.chips = chips;
        this.money = money;
        this.totalBet = totalBet;
        this.wins = wins;
        this.losses = losses;
        this.gamesBlackJack = gamesBlackJack;
        this.gamesRoulette = gamesRoulette;
        this.gamesUnknown = gamesUnknown;
    }
    //Username for login
    public void setUserName(String userName) {
        if(userName.length() <= 5){
            this.userName = userName;
        }
        else{
            this.userName = "defaultUser";
        }
    }
    //Return username for login
    public String getUserName() {
        return userName;
    }
    //Password for login
    public void setPassWord(String passWord) {
        if (passWord.length() <= 7) {
            this.passWord = passWord;
        }
        else{
            this.passWord = "defaultpass";
        }
    }
    //Return password for login
    public String getPassWord() {
        return passWord;
    }
    //Amount of chips in player account
    public void setChips(int chips) {
        this.chips = chips;
    }
    //Return amount of Chips in player account
    public int getChips() {
        return chips;
    }
    //Amount of money in player account
    public void setMoney(int money) {
        this.money = money;
    }
    //Return amount of money in player account
    public int getMoney() {
        return money;
    }
    //Amount of wins player has in games
    public void setWins(int wins) {
        this.wins = wins;
    }
    //Return the amount of wins player has in games
    public int getWins() {
        return wins;
    }
    //Amount of losses player has in games
    public void setLosses(int losses) {
        this.losses = losses;
    }
    //Return amount of losses player has in games
    public int getLosses() {
        return losses;
    }
    //Total amount player has bet as stat
    public void setTotalBet(int totalBet) {
        this.totalBet = totalBet;
    }
    //Return total amount player has bet as stat
    public int getTotalBet() {
        return totalBet;
    }
    //How many games of blackjack player has played
    public void setGamesBlackJack(int gamesBlackJack) {
        this.gamesBlackJack = gamesBlackJack;
    }
    //Return amount of times player has played blackjack
    public int getGamesBlackJack() {
        return gamesBlackJack;
    }
    //Amount of times player has played Roulette
    public void setGamesRoulette(int gamesRoulette) {
        this.gamesRoulette = gamesRoulette;
    }
    //Return amount of times player has played Roulette
    public int getGamesRoulette() {
        return gamesRoulette;
    }
    //Undecided third game setter
   /* public void setGamesUnknown(int gamesUnknown) {
        this.gamesUnknown = gamesUnknown;
    }
     */
    //Undecided third game getter
    public int getGamesUnknown() {
        return gamesUnknown;
    }
    public int addMoney(){
        if(this.money <= 25){
            this.money =+ 250;
        }
        return Integer.parseInt("Enough money still in account.");
    }
    public int exchangeMoneyChip(){
        int moneyToChip = 0;
        if(money > moneyToChip) {
            if (moneyToChip > 0) {
                chips =+ moneyToChip;
                money =- moneyToChip;

            }
        }
        return Integer.parseInt("No money to exchange for chips.");
    }
    public int exchangeChipMoney(){
        int chipToMoney = 0;
        if(chips > chipToMoney){
            if(chipToMoney > 0){
                money =+ chipToMoney;
                money =- chipToMoney;
            }
        }
        return Integer.parseInt("No chips to exchange for money.");
    }
}
