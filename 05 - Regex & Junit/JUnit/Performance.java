class Performance {
   public String longRunningTask() throws InterruptedException {
       Thread.sleep(3000);
       return "done";
   }
}
