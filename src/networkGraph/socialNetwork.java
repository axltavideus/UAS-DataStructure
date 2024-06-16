package networkGraph;

import java.util.List;
import java.util.Scanner;

public class socialNetwork {
    private static Scanner scanner = new Scanner(System.in);
    private static Graph graph = new Graph();

    public static void main(String[] args) {
        // Uncomment the next line to add 100 users and predefined friendships automatically
        addMultipleUsersWithFriendships();

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: adduser(); break;
                case 2: addFriendship(); break;
                case 3: removeuser(); break;
                case 4: removeFriendship(); break;
                case 5: findShortestPath(); break;
                case 6: displayConnectedComponents(); break;
                case 7: suggestFriends(); break;
                case 8: System.exit(0); break;
                default: System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Add user");
        System.out.println("2. Add Friendship");
        System.out.println("3. Remove user");
        System.out.println("4. Remove Friendship");
        System.out.println("5. Find Shortest Path");
        System.out.println("6. Display Connected Components");
        System.out.println("7. Suggest Friends");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void adduser() {
        System.out.println();
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user = new user(name, id);
        graph.adduser(user);
        System.out.println("user added: " + user);
    }

    private static void addFriendship() {
        System.out.println();
        System.out.print("Enter first user id: ");
        int id1 = scanner.nextInt();
        System.out.print("Enter second user id: ");
        int id2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user1 = graph.getUserById(id1);
        user user2 = graph.getUserById(id2);
        if (user1 != null && user2 != null) {
            graph.addFriendship(user1, user2);
            System.out.println("Friendship added between " + user1 + " and " + user2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    private static void removeuser() {
        System.out.println();
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user = graph.getUserById(id);
        if (user != null) {
            graph.removeuser(user);
            System.out.println("user removed: " + user);
        } else {
            System.out.println("user not found.");
        }
    }

    private static void removeFriendship() {
        System.out.println();
        System.out.print("Enter first user id: ");
        int id1 = scanner.nextInt();
        System.out.print("Enter second user id: ");
        int id2 = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user1 = graph.getUserById(id1);
        user user2 = graph.getUserById(id2);
        if (user1 != null && user2 != null) {
            graph.removeFriendship(user1, user2);
            System.out.println();
            System.out.println("Friendship removed between " + user1 + " and " + user2);
        } else {
            System.out.println();
            System.out.println("One or both users not found.");
        }
    }

    private static void findShortestPath() {
        System.out.print("Enter start user id: ");
        int startId = scanner.nextInt();
        System.out.print("Enter end user id: ");
        int endId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user startUser = graph.getUserById(startId);
        user endUser = graph.getUserById(endId);
        if (startUser != null && endUser != null) {
            List<user> path = graph.shortestPath(startUser, endUser);
            if (path != null && !path.isEmpty()) {
                System.out.println();
                System.out.println("Shortest path: ");
                for (user u : path) {
                    System.out.print(u + " ");
                }
                System.out.println();
            } else {
                System.out.println("No path found between " + startUser + " and " + endUser);
            }
        } else {
            System.out.println();
            System.out.println("One or both users not found.");
        }
    }

    private static void displayConnectedComponents() {
        List<List<user>> components = graph.connectedComponents();
        System.out.println();
        System.out.println("Connected Components: ");
        for (List<user> component : components) {
            for (user u : component) {
                System.out.print(u + " ");
            }
            System.out.println();
        }
    }

    private static void suggestFriends() {
        System.out.println();
        System.out.print("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        user user = graph.getUserById(id);
        if (user != null) {
            List<user> suggestions = graph.suggestFriends(user);
            System.out.println("Friend suggestions for " + user + ": ");
            for (user u : suggestions) {
                System.out.println(u);
            }
        } else {
            System.out.println("user not found.");
        }
    }

    private static void addMultipleUsersWithFriendships() {
        // Adding users with specific names and friendships
        String[] names = new String[]{
            "david_matthewww", "vincentmn08", "steven.g200605", 
            "kelvinvrdn", "desca.flx", "ccg_chessa", 
            "venneth.n", "cindyanetaa", "angleine.d",
            "snowsky_in", "ovanjas", "jehuda_sriwijaya",
            "wiraawn__", "jhnafy9", "ray_app", "dikkylie",
            "willimurmer_", "aurel_pricilla", "devon.studio.1801",
            "johnhxzell", "kenjimahoney", "enriko.rasya", "nia.vlrn",
            "priityaiss", "rifisded", "florenzathalita","louis.wqtz", 
            "justinkurniawan921", "andyyy.ko", "abielzchrs_","kei.nathan",
            "shrimpdings", "j.sonnnn_", "ceciliannda_", "jesikanatt", "richard8_h",
            "nicolasgerardwijaya", "luisfrnando_",  "altvincentt", "richieh_gt",
            "grace_1112.4", "aikorch", "re_di_705", "jesssmiracle", "jessjsphine",
            "kellyveisa", "wiranataureliuss", "marcellastelylukas", "claudioalvinoo_",
            "ferlyferdianliee", "carrens.gif", "vennyvincenzo", "sherlinemargaretaa",
            "awkalinnn", "vina245_", "weekent_", "jason_christiann", "_joycewongso",
            "ternoob", "geb_lin", "stevenrickyy", "samuelmarcelllo", "wezetice",
            "nathanaelvalent", "valentino_yerikho", "roy.pintooo", "bongtasya", "micheralles",
            "fer.71", "orlandojefferson_", "vicky_revando055", "jvnsuryadi", "antonius_8824","roypintooo",
            "jade_gabriel", "vintcen.n", "staviloe2", "raynardkurniawan", "justingbrll", "wronghousebro_",
            "rubben_febrian", "_williamlie_", "wndaprcl", "kezia_stemi", "giovannitan_", "hegar.rianto", "gregoriosamuel_criswell",
            "kevinreinhard16", "amadeusdarren_", "randyestevvan", "xander.yd", "jeremyhalim13", "jovvan99", "flo.aulia", "darrenlilipaly",
            "reynard_yapari"
        };
        for (int i = 0; i < names.length; i++) {
            user user = new user(names[i], i + 1);
            graph.adduser(user);
            System.out.println("user added: " + user);
        }

        // Establishing friendships
        addFriendshipByName("david_matthewww", "vincentmn08");
        addFriendshipByName("david_matthewww", "steven.g200605");
        addFriendshipByName("david_matthewww","kelvinvrdn");
        addFriendshipByName("david_matthewww","desca.flx");
        addFriendshipByName("david_matthewww","venneth.n");
        addFriendshipByName("david_matthewww","ccg_chessa");
        addFriendshipByName("david_matthewww","cindyanetaa");
        addFriendshipByName("david_matthewww","angleine.d");
        addFriendshipByName("david_matthewww","geb_lin");
        addFriendshipByName("david_matthewww","jesssmiracle");
        addFriendshipByName("david_matthewww","drndillon13");
        addFriendshipByName("david_matthewww","gregoriosamuel_criswell");
        addFriendshipByName("cindyanetaa","hegar.rianto");
        addFriendshipByName("cindyanetaa","ahza_rk");
        addFriendshipByName("cindyanetaa","snowsky_in");
        addFriendshipByName("desca.flx","kelvinvrdn");
        addFriendshipByName("desca.flx","nia.vlrn");
        addFriendshipByName("desca.flx","aikorch");
        addFriendshipByName("nia.vlrn","rifisded");
        addFriendshipByName("nia.vlrn","aikorch");
        addFriendshipByName("nia.vlrn","priityaiss");
        addFriendshipByName("nia.vlrn","kelvinvrdn");
        addFriendshipByName("nia.vlrn","jessjsphine");
        addFriendshipByName("grace_1112.4","aikorch");
        addFriendshipByName("grace_1112.4","kelvinvrdn");
        addFriendshipByName("grace_1112.4","jesssmiracle");
        addFriendshipByName("grace_1112.4","jesikanatt");
        addFriendshipByName("grace_1112.4","luisfrnando_");
        addFriendshipByName("grace_1112.4","re_di_705");
        addFriendshipByName("kelvinvrdn","jesikanatt");
        addFriendshipByName("drndillon13","rifisded");
        addFriendshipByName("drndillon13","steven.g_200605");
        addFriendshipByName("drndillon13","kei.nathan");
        addFriendshipByName("steven.g_200605","vincentmn_08");
        addFriendshipByName("geb_lin","vincentmn_08");
        addFriendshipByName("vincentmn_08","angleine.d");
        addFriendshipByName("randyestevvan","stevenrickyy");
        addFriendshipByName("randyestevvan","amadeusdarren_");
        addFriendshipByName("randyestevvan","gregoriosamuel_criswell");
        addFriendshipByName("randyestevvan","kevinreinhard16");
        addFriendshipByName("kevinreinhard16","amadeusdarren_");
        addFriendshipByName("shrimpdings","kei.nathan");
        addFriendshipByName("shrimpdings","j.sonnnn_");
        addFriendshipByName("justinkurniawan921","andyyy.ko");
        addFriendshipByName("justinkurniawan921","florenzathalita");
        addFriendshipByName("justinkurniawan921","dnxgt");
        addFriendshipByName("justinkurniawan921","abielzchrs_");
        addFriendshipByName("justinkurniawan921","shrimpdings");
        addFriendshipByName("florenzathalita","louis.wqtz");
        addFriendshipByName("louis.wqtz","dnxgt");
        addFriendshipByName("dnxgt","abielzchrs_");
        addFriendshipByName("abielzchrs_","kei,nathan");
        addFriendshipByName("j.sonnnn_","ceciliannda_");
        addFriendshipByName("j.sonnnn_","nicolasgerardwijaya");
        addFriendshipByName("ceciliannda_","ricahrd8_h");
        addFriendshipByName("nicolasgerardwijaya","luisfrnando_");
        addFriendshipByName("richard8_h","altvincentt");
        addFriendshipByName("altvincentt","richieh_gt");
        addFriendshipByName("altvincentt","wiranataureliuss");
        addFriendshipByName("nicolasgerardwijaya","kellyveisa");
        addFriendshipByName("kellyveisa","vennyvincenzo");
        addFriendshipByName("wiranataureliuss","marcellastelylukas");
        addFriendshipByName("wiranataureliuss","vennyvincenzo");
        addFriendshipByName("marcellastelylukas","carrens.gif");
        addFriendshipByName("marcellastelylukas","claudioalvinoo_");
        addFriendshipByName("claudioalvinoo_","ferlyferdianliee");
        addFriendshipByName("carrens.gif","vennyvincenzo");
        addFriendshipByName("carrens.gif","sherlinemargaretaa");
        addFriendshipByName("sherlinemargaretaa","awkalinnn");
        addFriendshipByName("awkalinnn","vina245_");
        addFriendshipByName("vina245_","ternoob");
        addFriendshipByName("ternoob","darrenlilipaly");
        addFriendshipByName("darrenlilipaly","_joycewongso");
        addFriendshipByName("darrenlilipaly","reynard_yapari");
        addFriendshipByName("_joycewongso","roypintooo");
        addFriendshipByName("darrenlilipaly","flo.aulia");
        addFriendshipByName("flo.aulia","jovvan99");
        addFriendshipByName("flo.aulia","xander.yd");
        addFriendshipByName("flo.aulia","jade_gabriel");
        addFriendshipByName("jade_gabriel","xander.yd");
        addFriendshipByName("jovvan99","jeremyhalim13");
        addFriendshipByName("jeremyhalim13","xander.yd");
        addFriendshipByName("jade_gabriel","jovvan99");
        addFriendshipByName("jade_gabriel","antonius_8824");
        addFriendshipByName("jade_gabriel","jvnsuryadi");
        addFriendshipByName("antonius_8824","jason_christiann");
        addFriendshipByName("antonius_8824","jvnsuryadi");
        addFriendshipByName("jvnsuryadi","jason_christiann");
        addFriendshipByName("jvnsuryadi","vicky_revando055");
        addFriendshipByName("jvnsuryadi","roy.pintooo");
        addFriendshipByName("roy.pintooo","vintcen.n");
        addFriendshipByName("vintcen.n","vicky_revando055");
        addFriendshipByName("vicky_revando055","orlandojefferson_");
        addFriendshipByName("vicky_revando055","fer.71");
        addFriendshipByName("orlandojefferson_","micheralles");
        addFriendshipByName("orlandojefferson_","bongtasya");
        addFriendshipByName("micheralles","bongtasya");
        addFriendshipByName("micheralles","fer.71");
        addFriendshipByName("fer.71","hson_j");
        addFriendshipByName("bongtasya","aurel_pricilla");
        addFriendshipByName("rifisded","enriko.rasya");
        addFriendshipByName("enriko.rasya","jason_christiann");
        addFriendshipByName("jason_christiann","kenjimahoney");
        addFriendshipByName("kenjimahoney","enriko.rasya");
        addFriendshipByName("kenjimahoney","johnxzell");
        addFriendshipByName("kenjimahoney","ccg_chessa");
        addFriendshipByName("johnxzell","enriko.rasya");
        addFriendshipByName("johnxzell","wezetice");
        addFriendshipByName("johnxzell","venneth.n");
        addFriendshipByName("johnxzell","dikkylie");
        addFriendshipByName("johnxzell","nathanaelvalent");
        addFriendshipByName("wezetice","samuelmarcelllo");
        addFriendshipByName("wezetice","weekent_");
        addFriendshipByName("samuelmarcelllo","weekent_");
        addFriendshipByName("samuelmarcelllo","jessjsphine");
        addFriendshipByName("samuelmarcelllo","ccg_chessa");
        addFriendshipByName("weekent_","priityaiss");
        addFriendshipByName("jessjsphine","priityaiss");
        addFriendshipByName("nathanaelvalent","valentino_yerikho");
        addFriendshipByName("valentino_yerikho","devon.studio.1801");
        addFriendshipByName("devon.studio.1801","aurel_pricilla");
        addFriendshipByName("aurel_pricilla","dikkylie");
        addFriendshipByName("dikkylie","venneth.n");
        addFriendshipByName("venneth.n","ccg_chessa");
        addFriendshipByName("venneth.n","willimurmer_");
        addFriendshipByName("devon.studio.1801","willimurmer_");
        addFriendshipByName("devon.studio.1801","staviloe2");
        addFriendshipByName("staviloe2","raynardkurniawan");
        addFriendshipByName("raynardkurniawan","_williamlie_");
        addFriendshipByName("_williamlie_","wronghouse_bro");
        addFriendshipByName("_williamlie_","rubben_febrian");
        addFriendshipByName("wronghouse_bro","rubben_febrian");
        addFriendshipByName("wronghouse_bro","willimurmer_");
        addFriendshipByName("rubben_febrian","willimurmer_");
        addFriendshipByName("wronghousebro_","devon.studio.180");
        addFriendshipByName("wronghousebro_","justingbrll");
        addFriendshipByName("ahza_rk","hegar.rianto");
        addFriendshipByName("ahza_rk","snowsky_in");
        addFriendshipByName("jehuda_sriwijaya","snowsky_in");
        addFriendshipByName("jehuda_sriwijaya","ovanjas");
        addFriendshipByName("ovanjas","angleine.d");
        addFriendshipByName("jehuda_sriwijaya","angleine.d");
        addFriendshipByName("jehuda_sriwijaya","wiraawn__");
        addFriendshipByName("wiraawn__","angleine.d");
        addFriendshipByName("wiraawn__","jhnafy9");
        addFriendshipByName("wiraawn__","ray_app");
        addFriendshipByName("wiraawn__","kezia_stemi");
        addFriendshipByName("jhnafy9","ray_app");
        addFriendshipByName("kezia_stemi","ray_app");
        addFriendshipByName("kezia_stemi","giovannnitan_");
        addFriendshipByName("kezia_stemi","wndaprcl");
        addFriendshipByName("ray_app","wndaprcl");
        
        
    }

    private static void addFriendshipByName(String name1, String name2) {
        user user1 = graph.getUserByName(name1);
        user user2 = graph.getUserByName(name2);
        if (user1 != null && user2 != null) {
            graph.addFriendship(user1, user2);
            System.out.println();
            System.out.println("Friendship added between " + user1 + " and " + user2);
        } else {
            System.out.println();
            System.out.println("One or both users not found.");
        }
    }
}
