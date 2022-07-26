public class SavingsAccount {

  private long total = 0;

  public synchronized boolean withdraw(long amount) {
      long temp_total = getTotal() - amount;
      boolean bool = false;

      if(temp_total >= 0){
        total = temp_total;
        System.out.println("Current Balance: $" + getTotal());
        bool = true;
      } else if (temp_total < 0) {
        System.out.println("Insufficient Funds");
      }else{
        System.out.print("Error. Please try again.");
      }

      return bool;
  }

  public synchronized void deposit(long amount) {
      total += amount;
      System.out.println("Current Balance: $" + getTotal());
  }

  public long getTotal() {
      return total;
  }
}