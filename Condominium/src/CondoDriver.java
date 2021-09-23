class CondoDriver {
    public static void main(String args[]) {
        Condominium c1 = new Condominium();
        Condominium c2 = new Condominium();

        Owner o1 = new Owner("Marie Curie", true);
        Owner o2 = new Owner("Peyton Manning", false);
        Owner o3 = new Owner("Ellen DeGeneres", true);
        Owner o4 = new Owner("Tony Blair", false);

        c1.addUnit(new Unit(101,o1));
        c1.addUnit(new Unit(102,o4));
        c1.addUnit(new Unit(201,o3));
        c1.addUnit(new Unit(202,o3));
        
        // You can have two different owners with the same name and gender
        Owner o5 = new Owner("John Doe", false);
        Owner o6 = new Owner("John Doe", false);
        c2.addUnit(new Unit(101,o5));
        c2.addUnit(new Unit(102,o6));
        c2.addUnit(new Unit(103,o3));
        c2.addUnit(new Unit(201,o2));
        c2.addUnit(new Unit(202,o5));
        c2.addUnit(new Unit(203,o3));
        
        System.out.printf("Condominium 1 has %d units and %d owners:\n",
        		c1.numUnits(), c1.numOwners());
        System.out.println(c1);
        System.out.printf("Condominium 2 has %d units and %d owners:\n",
        		c2.numUnits(), c2.numOwners());
        System.out.println(c2);
        System.out.println("Goodbye!");
    }
}