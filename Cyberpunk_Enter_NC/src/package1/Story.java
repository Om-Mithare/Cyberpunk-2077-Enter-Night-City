package package1;

import package2.CorpoEnemy;
import package2.Melee_FlameKatana;
import package2.Melee_Katana;
import package2.Melee_Knife;
import package2.MilitechRobot;
import package2.MilitechSoldier;
import package2.MilitechSpecOps;
import package2.OutlawsEnemy1;
import package2.OutlawsEnemy2;
import package2.OutlawsEnemy3;
import package2.SuperEnemy;
import package2.SuperWeapon;
import package2.Weapon_Pistol;
import package2.Weapon_Revolver;
import package2.Weapon_TechShotgun;

public class Story {
    
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    SuperEnemy enemy;
    int des_count = 0;
    int randEnemy = 0;
    int randMilitechEnemy = 0;
    int militechBase = 0;

    public Story(Game g, UI userInterface, VisibilityManager vManager)
    {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup()
    {
        player.hp = 20;
        player.maxHP = 20;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new SuperWeapon();
        player.currentWeapon.name = "None";
        ui.weaponNameLabel.setText("None");
        
        player.currentWeaponMelee = new Melee_Knife();
        ui.meleeWeaponName.setText(player.currentWeaponMelee.name);

        player.eddies = 100;
        ui.eddiesNumber.setText("" + player.eddies);

    }

    public void selectPosition(String nextPosition)
    {
        switch(nextPosition)
        {
            case "cityGate": cityGate(); break;
            case "talkGuard": talkGuard(); break;
            case "crossRoad": crossRoad(); break;
            case "bluffGuard": bluffGuard(); break;
            case "angryGuard": angryGuard(); break;
            case "attackGuard": attackGuard(); break;
            case "noPass": noPass(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "bribeGuard": bribeGuard(); break;
            case "attack": attack(); break;
            case "playerAttackGun": playerAttackGun(); break;
            case "playerAttackQuirk": playerAttackQuirk(); break;
            case "playerAttackMelee": playerAttackMelee(); break;
            case "enemyAttack": enemyAttack(); break;
            case "toTitleScreen": toTitleScreen(); break;
            case "rest": rest(); break;
            case "desert": desert(); break;
            case "militechBase": militechBase(); break;

        }
    }

    public void introduction()
    {
        ui.mainTextArea.setText("Your name is V and you are a Nomad(People who live outside Night City). \nYour goal is to enter Night City to start you journey and become a Night City Legend!");
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "cityGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void cityGate()
    {
        ui.mainTextArea.setText("You are at the gate of Night City \nYou see a corpo guard standing at the entrance\nWhat will you do?");
        ui.choice1.setText("Talk to the Guard");
        ui.choice2.setText("Attack the Guard");
        ui.choice3.setText("Leave");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }

    public void talkGuard()
    {
        ui.mainTextArea.setText("Corpo Guard: Wait right there! \nDo you have a Entry Pass?");
        ui.choice1.setText("Yes, i have one(Bluff)");
        ui.choice2.setText("No, don't have one");
        ui.choice3.setText("Bribe(1000 eddies)");
        ui.choice4.setText("Attack the guard");

        game.nextPosition1 = "bluffGuard";
        game.nextPosition2 = "noPass";
        game.nextPosition3 = "bribeGuard";
        game.nextPosition4 = "attackGuard";
    }

    public void bluffGuard()
    {
        ui.mainTextArea.setText("Corpo Guard: As expected from an Nomad.\nYou don't seem to have one.");
        ui.choice1.setText("Still better than a Corpo Slave");
        ui.choice2.setText("I will get one, later(Leave)");
        ui.choice3.setText("Bribe(1000 eddies)");
        ui.choice4.setText("Attack the guard");

        game.nextPosition1 = "angryGuard";
        game.nextPosition2 = "cityGate";
        game.nextPosition3 = "bribeGuard";
        game.nextPosition4 = "attackGuard";
    }

    public void noPass()
    {
        ui.mainTextArea.setText("Corpo Guard: Then you are not allowed to enter, you filthy Nomad");
        ui.choice1.setText("Still better than a Corpo Slave");
        ui.choice2.setText("Leave");
        ui.choice3.setText("Bribe(1000 eddies)");
        ui.choice4.setText("Attack the guard");

        game.nextPosition1 = "angryGuard";
        game.nextPosition2 = "cityGate";
        game.nextPosition3 = "bribeGuard";
        game.nextPosition4 = "attackGuard";
    }

    public void bribeGuard()
    {
        if(player.eddies >= 1000)
        {
            player.eddies = player.eddies-1000;
            ui.eddiesNumber.setText("" + player.eddies);
            ui.mainTextArea.setText("Corpo Guard: Oh a 1000 eddies. \nThey are not a lot but i will allow you to enter");
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else
        {
            ui.mainTextArea.setText("Corpo Guard: Don't play around. \nYou don't even have enough money to offer me");
            ui.choice1.setText("Leave");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "cityGate";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void angryGuard()
    {
        ui.mainTextArea.setText("Corpo Guard: Do you want to die Nomad. \n\nThe guard attacked you and your hp depleted by 8");
        player.hp = player.hp - 8;
        ui.hpNumberLabel.setText("" + player.hp);
        
        if(player.hp <= 0)
        {
            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else
        {
        ui.choice1.setText("Attack the guard");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "attackGuard";
        game.nextPosition2 = "cityGate";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
        }
    }

    public void attackGuard()
    {
        enemy = new CorpoEnemy();
        ui.mainTextArea.setText("Corpo Guard: Wrong move kid. \n" + enemy.name + ": " + enemy.hp + " HP");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "attack";
        game.nextPosition2 = "cityGate";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void attack()
    {

        ui.mainTextArea.setText(enemy.name + ": " + enemy.hp + " HP\n\nWhat do you do?");


        if(player.currentWeapon.name != "None")
        {
            ui.choice1.setText("Attack with Gun");
            ui.choice2.setText("Attack with Melee");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "playerAttackGun";
            game.nextPosition2 = "playerAttackMelee";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else
        {
            ui.choice1.setText("Attack with Melee");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "playerAttackMelee";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void playerAttackGun()
    {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        ui.mainTextArea.setText("You attacked the " + enemy.name + " and gave " + playerDamage + " damage!");
        enemy.hp = enemy.hp - playerDamage;
        
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(enemy.hp>0)
        {
            game.nextPosition1 = "enemyAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else if(enemy.hp<=0)
        {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void playerAttackMelee()
    {
        int playerDamage = new java.util.Random().nextInt(player.currentWeaponMelee.damage);
        ui.mainTextArea.setText("You attacked the " + enemy.name + " and gave " + playerDamage + " damage!");
        enemy.hp = enemy.hp - playerDamage;
        
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(enemy.hp>0)
        {
            if(player.currentWeaponMelee.quirk != "None")
            {
                game.nextPosition1 = "playerAttackQuirk";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }

            else
            {
                game.nextPosition1 = "enemyAttack";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        }

        else if(enemy.hp<=0)
        {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void playerAttackQuirk()
    {
        int quirkDamage = new java.util.Random().nextInt(player.currentWeaponMelee.quirkDamage);
        ui.mainTextArea.setText(enemy.name + " was hit by " + player.currentWeaponMelee.quirk + " effect and received " + quirkDamage + " damage!");
        enemy.hp = enemy.hp - quirkDamage;
        
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(enemy.hp>0)
        {
            game.nextPosition1 = "enemyAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else if(enemy.hp<=0)
        {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void enemyAttack()
    {
        int enemyDamage = new java.util.Random().nextInt(enemy.damage);
        player.hp = player.hp - enemyDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.mainTextArea.setText(enemy.attackMessage + "\nYou received " + enemyDamage + " damage");

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if(player.hp > 0)
        {
            game.nextPosition1 = "attack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        else if(player.hp <= 0)
        {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void win()
    {
        if(enemy == null || enemy.name == "Corpo Guard")
        {
            ui.mainTextArea.setText("YOU WIN!! \nYou entered Night City. \nYou are ready to become a Night City Legend. \nBut keep in mind, \n'In Night City you don't have happy endings'");
            ui.choice1.setText("Play Again");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "toTitleScreen";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        if(enemy.name == "Outlaw Level 1")
        {
            randEnemy++;
            player.currentWeapon = new Weapon_Pistol();
            ui.weaponNameLabel.setText(player.currentWeapon.name);
            player.eddies = player.eddies + 100;
            ui.eddiesNumber.setText("" + player.eddies);
            ui.mainTextArea.setText("You Win!! \n\nYou took a Pistol from the Outlaw \nYou also gained 100 eddies");
            ui.choice1.setText("Continue looking around");
            ui.choice2.setText("Leave");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "desert";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        if(enemy.name == "Outlaw Level 2")
        {
            randEnemy++;
            player.maxHP = player.maxHP + 10;
            player.hp = player.maxHP;
            ui.hpNumberLabel.setText("" + player.hp);
            player.eddies = player.eddies + 200;
            ui.eddiesNumber.setText("" + player.eddies);
            player.currentWeapon = new Weapon_Revolver();
            ui.weaponNameLabel.setText(player.currentWeapon.name);
            ui.mainTextArea.setText("You Win!! \n\nYou find a Revolver in the Outlaw Camp \nMax HP increased and you also gained 200 eddies");
            ui.choice1.setText("Continue looking around");
            ui.choice2.setText("Leave");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "desert";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

        if(enemy.name == "Outlaw Level 3")
        {
            des_count = 1;
            player.currentWeaponMelee = new Melee_Katana();
            ui.meleeWeaponName.setText(player.currentWeaponMelee.name);
            player.eddies = player.eddies + 300;
            ui.eddiesNumber.setText("" + player.eddies);
            player.maxHP = player.maxHP + 10;
            player.hp = player.maxHP;
            ui.hpNumberLabel.setText("" + player.hp);
            ui.mainTextArea.setText("You Win!! \n\nYou took a Katana from the Outlaw \nYour HP increase and you also gained 300 eddies");
            ui.choice1.setText("Leave");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

        if(enemy.name == "Militech Solider")
        {
            randMilitechEnemy++;
            player.maxHP = player.maxHP + 15;
            player.hp = player.maxHP;
            ui.hpNumberLabel.setText("" + player.hp);

            player.currentWeaponMelee = new Melee_FlameKatana();
            ui.meleeWeaponName.setText(player.currentWeaponMelee.name);

            ui.mainTextArea.setText("You Win!! \n\nYou found a Flame Katana from the Militech Camp \nYour hp also increased by 15");
            ui.choice1.setText("Proceed");
            ui.choice2.setText("Leave");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "militechBase";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

        if(enemy.name == "Militech Robot")
        {
            randMilitechEnemy++;
            player.maxHP = player.maxHP + 10;
            player.hp = player.maxHP;
            ui.hpNumberLabel.setText("" + player.hp);

            player.currentWeapon = new Weapon_TechShotgun();
            ui.weaponNameLabel.setText(player.currentWeapon.name);

            player.eddies = player.eddies + 200;
            ui.eddiesNumber.setText("" + player.eddies);

            ui.mainTextArea.setText("You Win!! \n\nYou found a Tech Shotgun \nYour HP also increased and you also found 200 eddies");
            ui.choice1.setText("Proceed");
            ui.choice2.setText("Leave");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "militechBase";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

        if(enemy.name == "Militech Spec Op")
        {
            militechBase++;
            player.eddies = player.eddies + 500;
            ui.eddiesNumber.setText("" + player.eddies);

            ui.mainTextArea.setText("You Win!! \n\nYou obtained 500 eddies");
            ui.choice1.setText("Leave");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

        
    }

    public void lose()
    {
        ui.mainTextArea.setText("YOU LOST!!\n 'In Night City you don't have happy endings'");
        ui.choice1.setText("Play Again");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitleScreen";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";   
    }

    public void toTitleScreen()
    {
        randEnemy = 0;
        des_count = 0;
        randMilitechEnemy = 0;
        militechBase = 0;
        defaultSetup();
        vm.showTitleScreen();
    }

    public void crossRoad()
    {
        if(des_count == 1 && militechBase == 0)
        {
            ui.mainTextArea.setText("You are at a crossroad outside Night City");
            ui.choice1.setText("Go to the No-Tell Motel");
            ui.choice2.setText("Wander around the desert");
            ui.choice3.setText("Go to the Militech base");
            ui.choice4.setText("Go the City Gate");

            game.nextPosition1 = "rest";
            game.nextPosition2 = "";
            game.nextPosition3 = "militechBase";
            game.nextPosition4 = "cityGate";
        }

        else if(des_count == 1 && militechBase == 1)
        {
            ui.mainTextArea.setText("You are at a crossroad outside Night City");
            ui.choice1.setText("Go to the No-Tell Motel");
            ui.choice2.setText("Wander around the desert");
            ui.choice3.setText("Go to the Militech base");
            ui.choice4.setText("Go the City Gate");

            game.nextPosition1 = "rest";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "cityGate";
        }

        else
        {
            ui.mainTextArea.setText("You are at a crossroad outside Night City");
            ui.choice1.setText("Go to the No-Tell Motel");
            ui.choice2.setText("Wander around the desert");
            ui.choice3.setText("Go to the Militech base");
            ui.choice4.setText("Go the City Gate");

            game.nextPosition1 = "rest";
            game.nextPosition2 = "desert";
            game.nextPosition3 = "militechBase";
            game.nextPosition4 = "cityGate";
        }
    }

    public void rest()
    {
        player.eddies = player.eddies - 4;
        player.hp = player.maxHP;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.eddiesNumber.setText("" + player.eddies);

        ui.mainTextArea.setText("You arrive at the No-Tell Motel and rest there for few hours \n\n4 eddies spent \nHealth restored");
        ui.choice1.setText("Go to the Cross Road");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void desert()
    {
        switch(randEnemy)
        {
            case 0: enemy = new OutlawsEnemy1(); break;
            case 1: enemy = new OutlawsEnemy2(); break;
            case 2: enemy = new OutlawsEnemy3(); break;
        }
        
        ui.mainTextArea.setText("You encountered a " + enemy.name + " in the desert. \n\n" + enemy.name + ": " + enemy.hp + " HP");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "attack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void militechBase()
    {
        switch(randMilitechEnemy)
        {
            case 0: enemy = new MilitechSoldier(); break;
            case 1: enemy = new MilitechRobot(); break;
            case 2: enemy = new MilitechSpecOps(); break;
        }
        
        ui.mainTextArea.setText("You encountered a " + enemy.name + " in the Militech Base. \n\n" + enemy.name + ": " + enemy.hp + " HP");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Leave");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "attack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

}
