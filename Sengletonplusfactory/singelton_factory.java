interface paymentstrategy{
    void pay(int amount);
}

class upipayment implements paymentstrategy{
    void pay(int amount){
        System.out.println("paid"+amount+"by upi");
    }
}
class ccpayment implements paymentstrategy{
    @Override
    public void pay(int amount) {
        System.out.println("paid"+amount+"by cc");
    }
}

class paymentcontext{
    private paymentstrategy strategy;
    public void setStrategy(paymentstrategy strategy){
        this.strategy=strategy;
    }
    void makepay(int amount){
        strategy.pay(int amount);
    }
}
class paymentFactory{

    static paymentstrategy getpaymentype(string type){
        if(type =="CC"){
            return new ccpayment();
        }
        if(type =="upi"){
            return new upipayment();
        }
    }

}

public class Main {
    public static void main(String[] args) {
        paymentcontext context = new paymentcontext();
        context.setStrategy(paymentFactory.getpaymenttype("cc"));
        context.makepay(1000);
    }
}
