package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg1 = new Zerg();
        zerg1.name = "fthufy";
        Zerg zerg2 = new Zerg();
        zerg2.name = "fthufchgy";
        Zerg zerg3 = new Zerg();
        zerg3.name = "fthuhfhfy";
        Zerg zerg4 = new Zerg();
        zerg4.name = "fthvjhufy";
        Zerg zerg5 = new Zerg();
        zerg5.name = "fthufvgjy";

        Protoss pr1 = new Protoss();
        pr1.name = "fthudfygdhfy";
        Protoss pr2 = new Protoss();
        pr2.name = "fthufcljhljhihgy";
        Protoss pr3 = new Protoss();
        pr3.name = "fthufczsftdshgy";

        Terran tr1 = new Terran();
        tr1.name = "fthufyutuhfy";
        Terran tr2 = new Terran();
        tr2.name = "fthufchkghmggy";
        Terran tr3 = new Terran();
        tr3.name = "fthuhfetsdghfy";
        Terran tr4 = new Terran();
        tr4.name = "fthvjhmkchkvufy";

    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
