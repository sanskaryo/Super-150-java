public class Abstract_client {

    Abstract_demo a = new Abstract_demo();
    a.PayOnline(); // This will call the implemented method in Abstract_demo class
    {


        @Override
        public void PayOnline() {
            System.out.println("Paying online...");
        }
    };
    
}
