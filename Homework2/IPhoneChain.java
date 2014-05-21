// assignment 2
// pair 027
// Cowart, Edwin
// escowart
// Bachiri, Zacharia
// bachiri

interface IPhoneChain {
}

class Link implements IPhoneChain {
    Player player;
    IPhoneChain left;
    IPhoneChain right;

    Link(Player player, IPhoneChain left, IPhoneChain right) {
        this.player = player;
        this.left = left;
        this.right = right;
    }

}

class Empty implements IPhoneChain {
}

class Player {
    String name;
    String phoneNum;

    Player(String name, String phoneNum) {
        this.name = name;
        this.phoneNum = phoneNum;
    }

}
