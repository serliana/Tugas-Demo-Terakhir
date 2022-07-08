package Hero;

import java.util.Random;
import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        // monster
        String[] enemies = { "Serpent", "Zombie", "Troll", "Goblin" };
        int maxEnemyHealth = 100;
        int enemyAttackDamage = 50;

        // player
        int health = 100;
        int attackDamage = 50;
        int numHealthPotion = 2;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("\n===============================================");
        System.out.println("|\t\tSELAMAT DATANG DI GAME HERO           |");
        System.out.println("|\t\t\t\t By Group 7                   |");
        System.out.println("===============================================");
        System.out.print("\tMasukkan Nama Pemain: ");
        String player = in.nextLine();

        GAME: while (running) {

            System.out.println("-----------------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t" + enemy + " lawanmu! \n");

            while (enemyHealth > 0) {
                System.out.println("\t" + player + "'s HP: " + health);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tApa yang ingin kamu lakukan?");
                System.out.println("\t1. Serang monster");
                System.out.println("\t2. Tambah Health");
                System.out.println("\t3. Lari");
                System.out.println("\t4. Keluar Game");
                System.out.print("\tMasukkan pilihan: ");
                String input = in.nextLine();

                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\n\t> " + player + " menyerang " + enemy + " dengan " + damageDealt + " damage.");
                    System.out.println(
                            "\t> " + player + " menerima " + damageTaken + " damage dalam pembalasan dari " + enemy + "");

                    if (health < 1) {
                        System.out.println(
                                "\n\t> " + player + " mengambil terlalu banyak damage," + player + " terlalu lemah untuk melanjutkan!");
                        break;
                    }
                } else if (input.equals("2")) {
                    if (numHealthPotion > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotion--;
                        System.out.println("\n\t> " + player + " tambah Health.\n\tMenyembuhkanmu untuk "
                                + healthPotionHealAmount + "." + "\n\t> " + player + " sekarang " + health + " HP."
                                + "\n\t" + numHealthPotion + " Sisa obat Health. \n");
                    } else {
                        System.out.println(
                                "\n\tKamu tidak memiliki obat penambah Health yang tersisa!\n");
                    }
                } else if (input.equals("3")) {
                    System.out.println("\n\t" + player + " lari dari " + enemy + "!");
                    continue GAME;
                } else if (input.equals("4")) {
                    System.exit(0);
                } else {
                    System.out.println("\n\tPerintah tidak valid!");
                }
            }

            if (health < 1) {
                System.out.println("\t> " + player + " keluar dari game, terlalu lemah untuk menyerang.");
                break;
            }

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("\t" + enemy + " dikalahkan oleh  " + player + ".");
            System.out.println("\t" + player + " memiliki " + health + " HP's tersisa.");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotion++;
                System.out.println("\t" + enemy + " menjatuhkan penambah Health! ");
                System.out.println("\tKamu sekarang memiliki " + numHealthPotion + " penambah Health.");
            }

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("\n\tApa yang ingin kamu lakukan sekarang?");
            System.out.println("\t1. Lanjutkan");
            System.out.println("\t2. Exit game");

            System.out.print("\tMasukkan pilihan: ");
            String input = in.nextLine();

            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("\tPerintah tidak valid");
                System.out.print("\tMasukkan pilihan: ");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("\n\t" + player + " melanjutkan game!");
            } else if (input.equals("2")) {
                System.out.println("\n\t" + player + " exit game.");
                break;
            }
        }

        System.out.println("\t********************************");
        System.out.println("\t*-  THANK YOU " + player + "!          -*");
        System.out.println("\t********************************");
    }
}

